package six;
import java.lang.reflect.Array;
import java.util.*;

public class Six_five {                 // 시간 복잡도 n^2
    public char solution(int n, int[] arr) {
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n ; j++) {
                if (arr[i] == arr[j])
                    return 'D';
            }
        }
        return 'U';
    }
    //해시 맵으로 중복 확인하면서 한다면 n
    public char solution1(int n, int[] arr) {   // 정렬로 푼다 n*logn
        char answer = 'U';
        Arrays.sort(arr);          //배열을 오름 차순으로 정렬한다,
        for (int i = 0; i < n-1; i++) {  // 정렬 되어있으니 인접한것만 비교하면 된다,
            if(arr[i] == arr[i+1])
                answer = 'D';
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Six_five T = new Six_five();
        System.out.println(T.solution(n, arr));
    }
}
