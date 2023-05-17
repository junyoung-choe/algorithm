package six;
import java.util.*;
public class Six_one {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {      // n-1 인 이유는 마지막 자리는 자연스럽게 제일 큰수가 등장한다.
            int min = arr[i], min_index = i;
            for (int j = i+1; j < n; j++) {         // 이중에서 가장 작은값이랑 i자리랑 바꾼다. 맨 앞자리는 한개씩 제외한다.
                if (min > arr[j]){
                    min = arr[j];
                    min_index = j;
                }
            }
            if (i != min_index){   // 제일 작은 숫자랑 i 인덱스를 가진 자리의 값을 바꾼다.
                int tmp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = tmp;
            }
        }
        for (int c: arr)
            answer.add(c);
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
        Six_one T = new Six_one();
        for (int i : T.solution(n, arr))
            System.out.print(i + " ");
    }
}
//왼쪽부터 차례로 가장 작은 숫자를 탐색하여 왼쪽으로 배치하는 방법으로, 바꾸는 숫자와 자리또한 교체합니다.
//제일 왼쪽에 가장 작은 숫자를 제외하면서 진행한다. (선택 정렬)
//이 또한 (n - 1)(n - 2) 횟수로 구성되어 있습니다.
//시간이 모자르면 컬렉션 대신 그냥 배열로 넘겨서 배열로 받는다.
//