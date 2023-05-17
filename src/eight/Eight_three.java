package eight;
import java.util.*;
public class Eight_three {
    static int n , m, sum = 0, time = 0, answer = Integer.MIN_VALUE;
    public void DFS(int L, int sum, int time, int[][] arr) {
        if (time > m) return; // 제한 시간을 걸면 그대로 리턴
        if(L == n){
            answer = Math.max(answer, sum);
        }
        else {
            DFS(L+1, sum+arr[L][0], time+arr[L][1], arr); // 값을 추가하는 경우
            DFS(L+1, sum, time, arr); // 값을 추가하지 않는 경우
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 문제의 갯수
        m = scanner.nextInt(); // 제한시간.
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt(); // 얻는 점수
            arr[i][1] = scanner.nextInt(); // 푸는 시간
        }

        Eight_three T = new Eight_three();
        T.DFS(0, 0,0, arr);
        System.out.println(answer);
    }
}
