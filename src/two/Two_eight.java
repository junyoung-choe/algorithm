package two;
import java.util.*;
public class Two_eight {
    public int[] solution(int size, int[] score) {
        int[] solution = new int[size];
        int cnt;

        for (int i = 0; i < size; i++) {
            cnt = 1;
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                if (score[i] < score[j]) cnt++;      // i의 점수가 다른 자리보다 작으면 등수를 하나씩 증가시킨다.
            }                                       // 이 원리를 사용시 중복되는 등수 다음은 +1 이 자동으로 된다.
            solution[i] = cnt;
        }
        return solution;
    }
        /* 굳이 몇명보다 앞서있는지 구할 필요가 없다.
        for (int i = 0; i < size; i++) {
            cnt = 0;
            for (int j = 0; j < size; j++) {
                if (i == j) continue;
                if (score[i] > score[j]) cnt++;
            }
            solution[i] = cnt;
        }
        return solution;
    }
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] score = new int[size];
        for (int i = 0; i < size; i++) {
            score[i] = scanner.nextInt();
        }
        scanner.close();

        Two_eight T = new Two_eight();
        for (int t : T.solution(size, score))
            System.out.print(t + " ");
    }
}
