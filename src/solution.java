import java.util.*;

class Point implements Comparable<Point>{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) { // 정렬법을 여기서 정한다. 오름차순이니 this가 뒤로 !
        if(this.x == o.x) return this.x - o.x;
        else return o.y - this.y - o.y;
    }
}

public class solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arrayList.add(new Point(x,y));
        }
        Collections.sort(arrayList);
        for (Point p : arrayList){
            System.out.println(p.x + " " + p.y);
        }
    }

}
