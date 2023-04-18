package two;
import java.util.ArrayList;
import java.util.Scanner;
public class Two_five {
    public int solution(int n) {
        int answer=0;
        int[] ch = new int[n+1]; // n+1 까지 사용해야 인덱스 n 까지 사용할수 있다.
        for (int i = 2; i <= n ; i++) { // 인덱스 0은 사용하지 않고 1은 소수가 아니기 때문에 제외한다, 그리고 1은 ch배열을 모두 1로 만든다.
            if(ch[i] == 0){         //2로 시작하며 2는 소수이기에 answer ++ 하고 2의 배수를 ch를 1로 바꾼다.
                answer++;
                for(int j=i; j<=n; j=j+i ) ch[j]=1; // j는 i의 배수만큼 증가하기 때문 그곳에 다 1을 넣어준다. 배수에 모두 대입한다
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        Two_five T = new Two_five();
        System.out.println(T.solution(n));

    }
}

// ch 배열을 제작하여 배열 안의 숫자를 0 or 1로 판별하며 약수가 존재하지 않는 숫자를 소수로 판단하는 알고리즘이다 기억하기!!