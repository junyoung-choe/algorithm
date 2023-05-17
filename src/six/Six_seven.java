package six;
import java.util.*;
class Point implements Comparable<Point>{ //Comparable 인터페이스에 있는 메소드 | 이 과정을 잘 기억하자 !!
    public int x , y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override //정렬하는 기준을 정해주는 메소드이다. 재정이 해준다
    public int compareTo(Point point) {                         // 그냥 외우기. 내림 or 오름 -> 상황이라고 가정하고 앞 뒤 값 어떤것을 빼줘야 음수가 나오는지 생각을 해보기
        if(this.x == point.x) return this.y - point.y;          // 오름차순 상황이라면 this에서 들어온 값을 빼줘서 리턴에 음수값이 나온다는 생각 |
        else return this.x - point.x;                           // 내림차순이라면 음수를 만드려면 들어온 값에서 this를 빼줘야한다 -> 음수값이 리턴되도록 해라 ! (정렬 만들때)
    }
}
public class Six_seven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr.add(new Point(x, y));          // 컬렉션에 객체 넣는거 잘 기억하기 !!
        }
        Collections.sort(arr);   // 컬렉션들 정렬하는 방법이다 Comparable 인터페이스에 있는 메소드이며, compareTo 여기의 정렬 기준으로 정렬한다.
        for(Point point : arr)
            System.out.println(point.x + " " + point.y);
    }
}
