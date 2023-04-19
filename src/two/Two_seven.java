package two;
import java.util.*;
public class Two_seven {
    public int solution(int size, int[] ox) {
        int[] score = new int[size];
        int answer = 0;
        int cnt = 0;
        for (int i=0; i<size; i++){
            if(ox[i] == 0) {
                cnt = 0;
                score[i] = cnt;
            }
            else {
                score[i] = ++cnt;
            }
            answer += score[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] ox = new int[size];
        for (int i = 0; i < size; i++) {
            ox[i] = scanner.nextInt();
        }
        scanner.close();
        Two_seven T = new Two_seven();
        System.out.println(T.solution(size, ox));
    }
}
