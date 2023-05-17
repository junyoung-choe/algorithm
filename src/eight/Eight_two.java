package eight;
import java.util.*;

public class Eight_two {
    static int answer = Integer.MIN_VALUE;
    static int n = 0, c = 0; // 굳이 main에서 리턴받지 않기 위해서 전체적으로 사용하기 위해서 여기에 선언
    public void DFS(int L ,int sum ,int[] arr) {
        if (sum > c) return; // 이걸 여기다가 쓰고 밑에 엔드 연산을 지운다는 생각 이걸로 몇 과정은 압축이 가능하다. 빼는 연산이 없기에 중간에서 c 보다크다면 밑 연산에서는 계속해서 커진다.
        if (L == n) { // 즉 여기를 들어온다면 더이상의 하위 트리는 생성하지 않는다.
            if (sum <= c && answer < sum) answer = sum;
        }
        else { // L -> 0 일때 부터 값을 더하거나 안더해서 보내주기에 위에 L == 0 이다.
            DFS(L+1, sum + arr[L], arr); // 이번 값을 더해서 보낸다 o
            DFS(L+1, sum, arr); // 이번 값을 더하지 않고 보낸다 x
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt(); // 트럭 무개
        n = scanner.nextInt(); // 바둑이의 마릿수
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Eight_two T = new Eight_two();
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
// 1번 2번 부분집합 문제이다 -> 트리 -> DFS.