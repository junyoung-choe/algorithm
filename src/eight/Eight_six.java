package eight;

import java.util.Scanner;

public class Eight_six {
    static int[] pm, ch, arr;
    static int n,m;
    public void DFS(int L) {
        if (L == m) {
            for (int i = 0; i < m; i++)
                System.out.print(pm[i] + " ");
            System.out.println();
        }
        else {
            for (int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = i; // arr의 몇번째 인덱스를 사용했는지 넣어준다.
                    pm[L] = arr[i]; // arr 배열의 숫자들을 차례로 넣어준다.
                    DFS(L + 1);
                    ch[i] = 0;
                    // pm[L] = 0; // 나오면서 어차피 덮어 쓰기에 0을 넣어주지 않아도 괜찮다.
                }
            }
        }
    }

    public static void main(String[] args) {
        Eight_six T = new Eight_six();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // n개 종류의 갯수
        m = scanner.nextInt(); // 뽑는 갯수 -> 집합의 내부의 원소 갯수
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        ch = new int[n]; // 체크 배열로 어떤 인덱스의 숫자가 들어 간적이 있는지 기록하는것
        pm = new int[m]; //
        T.DFS(0);

    }
}

