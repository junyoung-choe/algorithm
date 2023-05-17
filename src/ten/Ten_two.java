package ten;

import java.util.Scanner;

public class Ten_two {
    static int[] dy; // 동적 계획법을 사용시에
    public int solution(int n) {
        dy[1] = 1; // 문제를 소형화 시킨다.
        dy[2] = 2; // 문제를 소형화 시킨다.
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i-2] + dy[i-1]; // 원래 문제로 확대해 나간다.
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dy = new int[n+2]; // n+1 번 땅 까지 인덱스가 필요하기 때문이다.

        Ten_two T = new Ten_two();
        System.out.println(T.solution(n+1));

    }
}

// 도착지점이 +1 해야한다 7계의 돌 계단을 지나 도착지점인 땅으로 가야하니 말이 중요하다 문제 인식 중요 !!!!!!!