package six;
import java.util.*;
public class Six_three {
    public int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for (j = i -1; j >= 0; j++) {     // 버블정렬은 오른쪽에 제일 큰수가 차례대로 배치되므로 끝의 숫자를 하나씩 줄인다.
                if (arr[j] > tmp)
                    arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
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

        Six_three T = new Six_three();
        for (int x : T.solution(n, arr))
            System.out.print(x + " ");
    }
}

// 삽입정렬
// 2개부터 시작해서 n개의 비교를 하는 방법으로 버블과 선택 정렬이랑 차이가 존재한다.