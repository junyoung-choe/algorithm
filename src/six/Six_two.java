package six;
import java.util.*;
public class Six_two {
    public int[] solution(int n, int[] arr) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {     // 버블정렬은 오른쪽에 제일 큰수가 차례대로 배치되므로 끝의 숫자를 하나씩 줄인다.
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Six_two T = new Six_two();
        for (int x : T.solution(n, arr))
            System.out.print(x + " ");
    }
}
