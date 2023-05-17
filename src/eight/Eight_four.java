package eight;
import java.util.*;
public class Eight_four {
    static int[] pm;
    static int n, m;
    public void DFS(int L) {
        if (L == m) { // m개를 다 뽑아낸것
            for (int x : pm) // 계층에 다다랐을때 출력을 시킨다.
                System.out.print(x + " ");
            System.out.println();
        }
        else {
            if(L != 0)
            for (int i = 1; i <= n; i++) { // 트리를 제작한다 ! 재귀함수를 호출한다는 동작을 트리를 만든다고 생각하기
                pm[L] = i;  // 계속해서 덮어 씌운다.
                DFS(L+1);
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 몇번째 숫자까지 가능한지
        m = scanner.nextInt(); // 몇개의 묶음으로 부분집합인지
        pm = new int[m]; // 전역으로 생성
        Eight_four T = new Eight_four();
        T.DFS(0);
    }
}


// 중복을 포함한다.