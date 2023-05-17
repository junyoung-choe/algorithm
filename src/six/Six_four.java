package six;
import java.util.*;
public class Six_four {
    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];    // 프로세서 공간

        for (int i = 0; i < n; i++) { // n개의 프로세스를 진행시킬 예정이다.
            boolean check = false;
            int index = 0;
            for (int j = 0; j < s; j++) {
                if (answer[j] == arr[i]) {    // cache hit 인지 확인하기
                    check = true;
                    index = j; // 캐쉬 안에 같은 프로세서가 존재하는 인덱스 번호
                    break;
                }
            }
            if(check) {       // cache hit
                for (int j = index; j > 0; j--)
                    answer[j] = answer[j-1];      // 같은 프로세서를 지우면서 해당 인덱스의 앞으 프로세서들을 한칸씩 미룬다.
                answer[0] = arr[i];
            }
            else {// cache miss
                for (int j = s-1; j > 0; j--)
                    answer[j] = answer[j-1];     // 모든 프로세스들을 한칸씩 뒤로 미룬다.
                answer[0] = arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();   // 실행환경인 메모리의 크기
        int n = scanner.nextInt();   // 실행되는 프로세스들
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        Six_four T = new Six_four();
        for (int i : T.solution(s, n, arr))
            System.out.print(i + " ");
    }
}

// ArrayList로 인덱스 번호로 넣으면 자동으로 뒤에가 밀리면서 편리하게 사용할수 있지만
// 알고리즘을 사용하여 직접 손코딩 하는 능력이 중요하다.
// 들어오는 프로세스는 반드시 맨 앞에 위치해야한다. (겹치는 경우에도)
// arr[i] = arr[i-1] 한칸씩 뒤로 미룬다는 생각 !