package ten;
import java.util.*;
public class Ten_three {
    static int[] dy;

    public int solution(int n, int[] arr) {
        dy[0] = 1; // 0번째 수열은 자기 자신만 가능하므로 1로 고정한다.

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) { // 해당 i 자리의 원소가 이전 인덱스의 원소보다 크다면
                    if (dy[i] <= dy[j])
                        dy[i] = dy[j] + 1 ; // 동적 배열의 숫자가 앞보다 크다면 +1 저장한다. ( 그 뒤에 현재 수를 세울수 있으므로)
                }
                else dy[i] = 1; // 모든 앞 원소 보다 작다면 자기 자신만 가능하므로 1이다.
            }
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dy[i]); // 가장 큰 수를 가져온다.
        }
        return answer;
    }

    public int solution2(int[] arr) { // 선생님 풀이 위에랑 어떤것이 다른지 확인해보기 !
        int answer = 0;
        dy[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i-1; j >=0 ; j--) {
                if (arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max+1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Ten_three T = new Ten_three();
        System.out.println(T.solution(n, arr));
    }


}
// arr, dy 배열을 잡는다.
// 5 3 7 8 6 2 9 4 -> 3 7 8 9  원래 순열의 순서는 바꿀수 없다
// 5 9 7 8 6 2 3 4 -> 5 7 8 or 2 3 4 로 순서가 바뀌면 최대 갯수도 바뀐다.