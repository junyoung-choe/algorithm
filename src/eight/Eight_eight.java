package eight;

import java.util.Scanner;

public class Eight_eight {
    static int n, f;
    static int[] b, p, ch; // 중복순열이 아니고 순열이기에 ch가 필요하다.
    boolean flag = false; // 답 찾으면 재귀 멈추려고 하는것
    int [][] dy = new int[35][35]; // nCn 을 구할때 메모리 제이션을 진행한다.
    public int combi(int n, int r) { // nCn 을 알아내기 위해서 구한다. seven 에서 구현했던거
        if (dy[n][r] > 0) return dy[n][r];
        if (n ==r || r==0) return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public void DFS (int L, int sum) {
        if(flag) return; // 찾으면 그냥 다 리턴 시킨다.
        if(L==n){ // 하나의 순열이 완성
            if(sum == f) {
                for(int x : p) System.out.print(x+" ");
                flag = true;
            }
        }
        else {
            for(int i = 1;i<=n ;i++ ) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum+(p[L] * b[L])); // b는 컴비네이션 결과
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Eight_eight T = new Eight_eight();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 1 ~ n 까지의 숫자이자 답의 갯수이다.
        f = scanner.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];

        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n-1, i); // n 까지의 숫자를 배열에 담는다.
        }
        T.DFS(0,0);
    }

}
// 중복 순열을 이용해서 1~4 까지의 숫자가 최종에 도착했을때 몇개가 사용됬는지 생각해보기 !
// 이 순서대로 피라미드 반대모양으로 파이널 값을 구한다면 (옆 수와의 합을)
// {1, 2, 3, 4} 4개의 숫자이니 3C0, 3C1, 3C2, 3C3 즉 1, 3, 3, 1 의 각 자리의 숫자들이 사용된다.