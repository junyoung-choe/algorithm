package eight;
import java.util.*;
public class Eight_seven {
    static int[][] memory; // 메모리제이션 변수.
    public int DFS(int n, int r) {
        if (memory[n][r] != 0) return memory[n][r];
        if (n == r) return 1;
        else if (r == 0) return 1;
        else {
            return memory[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Eight_seven T = new Eight_seven();

        int n = scanner.nextInt();
        int r = scanner.nextInt();
        memory = new int[n+1][r+1];
        System.out.println(T.DFS(n,r)); // n과 r이 들어간 DFS(n, r) 일때 이리로 리턴하는 것이지 그 밑에 숫자들은 (ex DFS(4,2)) 내려오지 않고 위에서 스택이 쌓인다.

    }
}
// 메모리 제이션은 체크처럼 0 or 1로 기록하는 것이 아니라 해당 값을 저장해놓구 바로 사용함으로써 메모리를 절약하낟.