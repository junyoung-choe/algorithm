package ten;
import java.util.*;
public class Ten_one {
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
        dy = new int[n+1]; // 7번 계단까지 인덱스가 필요하기 때문이다.

        Ten_one T = new Ten_one();
        System.out.println(T.solution(n));

    }
}
// 복잡도로 따졌을때 대단히 복잡한 문제를 (본질의 변형 없이) 소형화를 시킨다.
// ex 계단 20개 짜리 올라가는 방법을 계단 2개를 올라가는 방법으로 바꾼다 ( 직관적으로 알수 있게 )
// 2계단 올라가는 방법을 메모리 제이션(dy)을 이용해서 3계단, 4계단, 5계단 ~ 20계단 을 올라가는 방법으로 바꾼다.