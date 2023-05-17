package eight;
import java.util.*;
public class Eight_one {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr) { // answer 를 전역변수로 선언하고, DFS() 함수의 리턴형을 void로 간다.
        if (flag) return; // 이후의 트리 제작을 방지한다.
        if(sum > total/2) return; // 이거를 추가하면 더 좋은 코드가 된다.
        if(L==n) {  // L이 6즉 말단에 갔을때 부분집합이 완성되는 것이다. 말단만을 위해 있는 if 문이라고 생각하면 된다.
            if((total - sum) == sum) { // 말단인데 답이 아니면 그냥 지나간다.
                answer = "YES";
                flag = true; // 답이 나온 이후에 재귀를 끝내려고. ( 밑에 스택들이 돌아가며 새로운 스택을 만드는것을 방지한다.
            }
        }
        else { // 두 갈래로 뻗어서 나간다.
            DFS(L+1, sum + arr[L], arr ); // 다음 부분집합의 원소를 사용하겠다.
            DFS(L+1, sum, arr);     // 다음 부분집합의 원소를 포함시키지 않겠다.

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        Eight_one T = new Eight_one();
        T.DFS(0, 0, arr); // 0 부터 넣고 arr이 범위를 지정할거다.
        System.out.println(answer);
    }
}
