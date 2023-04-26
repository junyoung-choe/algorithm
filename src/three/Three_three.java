package three;
import java.util.*;
public class Three_three {

    public int solution(int n, int k, int[] record){
        int answer = 0;

        for (int i = 0; i < n-k+1; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += record[i+j];
            }
            if (sum > answer) answer = sum;
        }
        return answer;
    }
    // 이거는 복잡도가 n * k 이다.
    // 복잡도가 n이 되도록 설계해야한다.
    public int solution2(int n, int k, int[] record) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += record[i];         // 초기 k 길이의 윈도우의 합을 구한다.
        }
        for (int i = k; i < n; i++) {
            sum += (record[i]-record[i-k]);     // 윈도우에서 빠진 수는 빼고 추가된 수는 더해준다.
            answer = Math.max(answer, sum);     // 더 큰수를 대입하는 함수
            // if (answer < sum) answer = sum;
        }
        return answer;
    }
    //시간 복잡도가 훨신더 줄어든다. 즉 n 번만 실행하면 된다.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 날짜
        int k = scanner.nextInt(); // 연속된 날짜
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            record[i] = scanner.nextInt();
        }
        scanner.close();
        Three_three T = new Three_three();
        System.out.println(T.solution2(n, k, record));
    }
}

// answer = Math.max(answer, sum);     // 더 큰수를 대입하는 함수
// 시간 복잡도를 줄일수 있는 설계를 생각하자