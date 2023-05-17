package eight;
import java.util.*;
public class Eight_nine {
    static int n,m;
    static int[] combi;

    public void DFS(int L, int s) {
        if(L == m){
            for (int t : combi)
                System.out.print(t + " ");
            System.out.println();
        }

        else {
            for (int i = s; i <= n; i++) { // 다른점
                combi[L] = i;             // 다른점
                DFS(L+1, i+1); // 다른점 | i번 뻗은것에 +1 한다.
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 자연수 1~n
        m = scanner.nextInt(); // 집합의 원소 갯수
        combi = new int[m]; // m 크기의 배열 선언
        Eight_nine T = new Eight_nine();
        T.DFS(0,1); // 다른점 0, 1 로 시작한다는것을 기억하자 !
    }
}

//조합을 구하는 방법 ( 중복이 없이 순열의 순서도 차이가 없다고 생각한다.)
// (1,3)(3,1) 같은것이다.
// 조합이라는것을 외운다.
