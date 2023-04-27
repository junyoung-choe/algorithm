package three;
import java.util.*;

public class Three_five {
    public int solution(int n) {
        int answer = 0;
        int sum = 0, lt = 1;
        for (int rt = 0; rt < (n/2)+1; rt++) {  // 연속된 숫자의 합은 해당 숫자의 /2 +1 까지만 구한다 !!
            sum += rt;
            if (sum == n) answer++;
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) answer++; // while 조건이 같은수일때도 있고 | 뺏을때도 목표값이 나올수 있기때문에
            }
        }
        return answer;
    }

    public int solution1(int n) { // 수학적인 방법을 사용
        int answer = 0, cnt=1;               // ex n = 15
        n--;                                 // n -> 14
        while(n>0) {
            cnt++;
            n -= cnt;                        //1. n -> 12 ( 2를 뺐다.)    2. n -> 9 ( 3을 뺐다.)
            if(n%cnt==0) answer++;           //뺀 숫자를 갯수로 나눠서 떨어진다면 연속적인 숫자가 가능한것 !    합의 숫자들의 갯수는 한 세트밖에 없다 !
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        Three_five T = new Three_five();
        System.out.println(T.solution(n));
    }
}
// 연속된 숫자의 합으로 해당 숫자를 구하려면 (n/2 +1) 전까지만 구해도 충분하다.
// solution 1번 방법 -> 연속된 숫자들의 합이면 2개부터 시작한다.
// (1) 1, 2 -> 15 - 3 -> 12 % 2 -> 1+6 + 2+6 가능
// (2) 1, 2, 3 -> 15 - 6 -> 9 % 3 -> 1+3 + 2+3 + 3+3 가능
// (3) 1, 2, 3, 4-> 15 - 10 -> 5 % 4 -> 나눠 떨어지지 않음 불가
// (4) 1, 2, 3, 4, 5 -> 15 -15 -> 0 % 5 -> 1+0 + 2+0 + 3+0 + 4+0 + 5+0 가능
// 수학적 알고리즘이다 알고 있자 !!