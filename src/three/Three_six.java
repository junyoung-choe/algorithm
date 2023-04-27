package three;
import java.util.*;
public class Three_six {
    public int solution(int n, int k, int[] arr) {
        int answer =0, cnt = 0, lt = 0;     //cnt는 0을 1로 바꾼 횟수
        for(int rt =0; rt<n; rt++){
            if(arr[rt]==0) cnt++;           // 실제로 바꾸지는 않고 바뀌었다고 생각하기
            while(cnt>k) {
                if (arr[lt] == 0)
                    cnt--;
                lt++;  //1인 지점만 나온다면 계속 1씩 증가.    // 0인 지점에 만났을때도 +1 하는 이유는 rt가 0인 지점으로 가있기 때문이다. 둘다 한칸씩 더간다는 생각하기!!
            }
            answer = Math.max((rt - lt + 1), answer);
        }


        return answer;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Three_six T = new Three_six();
        System.out.println(T.solution(n,k,arr));
    }
}
