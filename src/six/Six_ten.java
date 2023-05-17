package six;
import java.util.*;
public class Six_ten {

    public int count(int mid, int[] arr) {   // c는 말을 갯수로 count는 말의 마릿수를 리턴한다.
        int horse = 1, position = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if((arr[i] - position) >= mid){  // 세마리로 가정한다면 3마리의 가운데의 말은 양쪽에 둘다 최소 이상의 거리를 유지해야 한다.
                horse++;
                position = arr[i];
            }
        }
        return horse;
    }

    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);               // 여기서 최대 최소를 이렇게 지정해도 위에 count에서는 실제의 값을 가지고 다루기 때문에 실제 가능한 답변의 답이 나온다.
        int lt = 1;                     // 실제의 차이의 값만 가능하지만 rt와 lt 사이에 모든 값이 가능하다고 가정한다. 1이 가장 적은 거리라고 생각을 하면 좋다.
        int rt = arr[n-1];              // 거리의 최댓값 ( 말도 최소 갯수인 2개로 가정해서 제일 큰 값을 생각한다 ) 이것도 최대값이 이거라고 가정한다.
        while (lt <= rt) {
            int mid = (lt+rt)/2;        // 첫번째 -> 가장 가까운 거리기 5라고(mid) 가정하고 말들을 배치한다.
            if (count(mid, arr) >= c) { // 즉 가능한상황 -> 최댓값을 구하기 위해서 오른쪽을 더 탐색해본다.
                lt = mid+1;
                answer = mid;           // 최신의 가능한 값을 answer에 넣어놓는다.
            }
            else rt = mid-1;                                   // 배치 가능한 마릿수가 c 보다 적다 즉 불가능하다. 더 적은 거라를 탐색한다.
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 마굿간의 갯수
        int c = scanner.nextInt();  // 말의 갯수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Six_ten T = new Six_ten();
        System.out.print(T.solution(n,c,arr));
    }
}

// 결정 알고리즘 답이 될수있는 것들의 범위를 먼저 생각한다.