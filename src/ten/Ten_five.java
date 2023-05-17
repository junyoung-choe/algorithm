package ten;
import com.sun.tools.javac.Main;

import java.util.*;
public class Ten_five {
    static int n, m;
    static int[] dy;
    public int solution(int[] coin) {
        Arrays.fill(dy, Integer.MAX_VALUE); // dy 배열을 모두 해당 숫자로 초기화
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j < m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        Ten_five T = new Ten_five();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //동전 종류의 갯수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        m = scanner.nextInt(); // 목표 금액
        dy = new int[m+1];
        System.out.println(T.solution(arr));
    }
}

// 앞의 같은 문제는 동전의 종류가 12개 였다. 그래서 DFS 가능
// 지금 문제는 동전의 종류가 50개 이므로 DP로 풀어야 한다.
