package two;
import java.util.ArrayList;
import java.util.Scanner;
public class Two_three {

    public ArrayList<Character> solution(int times, int A[], int B[]) {
        ArrayList<Character> answer = new ArrayList<>();
        /*
        for (int i = 0; i < times; i++) {
            if (A[i]==1){
                if (B[i] == 2) answer.add('B');
                else if (B[i] == 3) answer.add('A');
                else answer.add('D');
            } else if (A[i]==2){
                if (B[i] == 1) answer.add('A');
                else if (B[i] == 3) answer.add('B');
                else answer.add('D');
            } else if (A[i]==3){
                if (B[i] == 1) answer.add('B');
                else if (B[i] == 2) answer.add('A');
                else answer.add('D');
            } else System.out.println("잘못 입력 하셨습니다.");
        }
        */
        for (int i = 0; i < times; i++) {
            if(A[i]==B[i]) answer.add('D');
            else if (A[i]==1 && B[i]==3) answer.add('A');
            else if (A[i]==2 && B[i]==1) answer.add('A');
            else if (A[i]==3 && B[i]==2) answer.add('A');
            else answer.add('B');

        }
        return answer;
    }
    // if A == B else if 1 else if 2 else if 3  esle (모두 B가 이기는 경우) 이게 더 효율족

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int A[] = new int[times];
        int B[] = new int[times];
        for (int i = 0; i < times; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < times; i++) {
            B[i] = scanner.nextInt();
        }
        scanner.close();

        Two_three T = new Two_three();
        // System.out.println(T.solution(times,A,B)); // 이렇게 ArrayList 바로 출력해도 가능하다 | 한줄로 출력
        for (char c : T.solution(times, A, B)){
            System.out.println(c);
        }
        // 만약에 스트링으로 받았으면 .toCharArray
    }
}       // 알고리즘 효율적으로 짜는거 생각해보기
