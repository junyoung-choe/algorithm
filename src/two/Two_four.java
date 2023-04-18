package two;
import java.util.ArrayList;
import java.util.Scanner;
public class Two_four {
    public int[] solution(int n) {
        // 손코딩 a,b,c 사용해서 a+b=c -> c c출력후  a =b , b=c 계속 돌려서 실행할수 있다, !
        /* 전 값을 사용해야 하기 때문에 컬렉션 보다는 배열이 용이할듯
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1); answer.add(1); // 0~1 1로 초기화.
        for (int i=2; i<n; i++){
        }
        */
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        Two_four T = new Two_four();
        for (int i : T.solution(n)){
            System.out.print(i + " ");
        }
    }
}
