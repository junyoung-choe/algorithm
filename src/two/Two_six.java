package two;
import java.util.*;
public class Two_six {
    public boolean isPrime(int num){          // 소수이냐? | 이렇게 판별하는 함수를 따로 제작한다 !
        if(num == 1) return false;            // 소수에서 1은 항상 따로 써준다.
        for(int i=2; i<num; i++){             // 2부터 해당 숫자 전까지의 숫자중 약수가 없어야 소수이기 때문이다 !
            if((num % i) == 0) return false;  // 이게 참이라면 num의 약수가 존재한다는 뜻이다.
        }
        return true;
    }

    public ArrayList<Integer> solution(int size, int numbers[]) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int tmp = numbers[i]; // 그냥 변수 하나 사용하는것이 더 좋다, tmp를 밑에서 또 사용해야 하기도 때문이다.
            int res = 0;
            while(tmp > 0) {
                int t = tmp%10;     // tmp에서 1의 자리 숫자를 가져온다...
                res = res * 10 + t; // res는 거꾸로 만드는 숫자의 결과가 된다..
                tmp = tmp/10;
            }
            if(isPrime(res)) answer.add(res);     // 리턴이 boolean 타입이니 !
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        Two_six T = new Two_six();
        for (int t : T.solution(size, numbers))   // 컬렉션을 사용하여 값을 하나씩 받아온다.
            System.out.println(t + " ");
    }
}


// 어떤 숫자든 % 10 한다면 남은 숫자는 1의자리 숫자이다 !   123 % 10 -> 3
// 어떤 숫자든 / 10 한다면 남은 1의자리 숫자는 없어진다 !   123 / 10 -> 12
// 어떤 숫자가 소수인지 구별하기 위해서는 그 숫자보다 작은수들 (1을 제외한) 중 약수가 있는지 없는지 판별한다 ( % i 통해서)