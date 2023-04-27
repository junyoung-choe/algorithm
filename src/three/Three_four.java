package three;
import java.util.*;
public class Three_four {
    public int solution(int n, int m, int[] arr) {   // 시간 복잡도 n^2 -> n 으로 끝내야겠다는 생각 !
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == m) {
                    answer++;
                    break;
                }
                else if (sum > m) break;
            }
        }

        return answer;
    }
    public int solution1(int n, int m, int[] arr) { // 시간복잡도 n
        int answer = 0;
        int sum = 0;
        int lt = 0, rt;
        for (rt = 0; rt < n; rt++){
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if(sum==m) answer++;      //빼고 나서도 확인해봐야 한다.
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Three_four T = new Three_four();
        System.out.println(T.solution1(n, m, arr));
    }
}
