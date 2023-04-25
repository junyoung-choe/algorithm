package two;
import java.util.*;
public class Two_eleven {
    public int solution(int size, int[][] students) {
        int answer = 0;
        int cnt = 0;
        int[] king = new int[size]; // 겹치는 횟수. 겹치는 학생이 많아도 +1 씩 되는것이다 !
        for (int i = 0; i < size; i++) { // i는 확인하는 학생
            cnt = 0;
            for (int j = 0; j < 5; j++) { // j는 대상 학생의 학년을 올려준다. 즉 열을 담당한다.
                for (int k = 0; k < size; k++) {  // 대상 학생과 같은반 학생을 확인한다.
                    if (k != i && students[i][j] == students[k][j]) {
                        cnt++;
                        break;
                    }
                }
            }
            king[i] = cnt;
        }
        for (int i = 0; i < size; i++) {
            if (answer < king[i]) answer = king[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] students = new int[size][5];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 5; j++) {
                students[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        Two_eleven T = new Two_eleven();
        System.out.println(T.solution(size, students) + 1);
    }

}

// 3중 for문에 대해서 이해하자 !