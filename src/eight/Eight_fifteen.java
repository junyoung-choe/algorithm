package eight;
import java.util.*;

class Point2 {
    int x, y;
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Eight_fifteen {
    static int[][] arr;
    static int n,m,len,answer = Integer.MAX_VALUE; // -> answer 는 도시의 피자배달 거리가 된다.
    static int[] combi; // 조합을 구한다.
    static ArrayList<Point2> pizza, home;

    public void DFS(int L, int s) {
        if(L == m){
            int sum=0;
            for (Point2 h : home) {
                int dis = Integer.MAX_VALUE;   // 한 집에서 조합으로 선택된 4개의 피자집중에 가장 가까운 집의 거리
                for (int i : combi){
                    dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y)); // Math.abs 절댓값을 불러온다.
                }
                sum += dis; // 각 집의 최소거리를 합해준다.
            }
            answer = Math.min(answer, sum);   // 어떤 조합일때 각 집의 최소 피자집과의 거리의 합이 가장 적은지 찾아낸다.

//            for (int x : combi) System.out.print(x + " ");
//            System.out.println();
        }
        else {
            for (int i = s; i < len; i++) {  // 이 세줄 조합을 만드는것 외워두자 ! | 뒤에 카드번호가 있어서 뽑은 순서는 중요치 않고 결과만 중요하다면 ! 조합 !
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }


    public static void main(String[] args) {

        Eight_fifteen T = new Eight_fifteen();
        Scanner sc = new Scanner(System.in);
        home = new ArrayList<>();
        pizza = new ArrayList<>();

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1][n+1];  // 0번 인덱스는 사용하지 않는다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) home.add(new Point2(i,j));    // 집 위치의 ArrayList
                if (arr[i][j] == 2) pizza.add(new Point2(i,j));   // 피자집 위치의 ArrayList
            }
        }
        len = pizza.size(); // len C m 을 구하려고 한다.
        combi = new int[m];
        T.DFS(0,0);
        System.out.println(answer);





    }

}


// 6개중 4개의 피자집의 경우는 6개중 4개를 선택하는걸로 6C4 이다 -> 6! / 4! * (6-4)! -> 15가지의 경우가 가능하다.
// 1. 입력받은 피자집 갯수중에, m 개의 피자집만 운영할거다 어떤 m개의 피자집에 가장 효율적일까 ?!
// 2. 입력받은 피자집 C m 개의 피자집으로 조합의 경우의 수가 존재한다.
// 3. DFS를 이용해서 조합을 구하며 m개의 갯수일때 뽑혀진 피자집들과 각 집들과의 거리를 계산하며 최소의 거리의 합을 구한다.
// 4. 어떤 조합일때 최소의 값인지 그 최소의 값을 구한다.
// 물론 각 집에서의 현재 피자집의 최소 거리를 구할수 있지만 각 집에서 가장 가까운 피자집을 선택하면 그 피자집들이 m개가 넘을수도 있다.
// 그러므로 6개중 4개를 뽑는 그 경우중에 최선을 구해야 한다
// 나는 접근을 잘못 했었다 !