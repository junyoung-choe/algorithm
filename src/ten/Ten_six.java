package ten;
import java.util.*;
import java.util.stream.StreamSupport;

public class Ten_six {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dy = new int[m+1];  //인덱스를 다음 번호까지 생성한다. (0부터 해당 점수까지의 동적 배열을 생성한다.)
        for (int i = 0; i < n; i++) {
            int ps = scanner.nextInt(); // 풀면 얻는 스코어
            int pt = scanner.nextInt(); // 풀때 걸리는 시간
            for (int j = m; j >= pt ; j--) { // 중복을 방지하고자 뒤에서부터 해당 점수까지만.
                dy[j] = Math.max(dy[j], dy[j - pt] + ps);
            }
        }
        System.out.println(dy[m]);
    }
}


// 1 ~ 50 까지이기에 DP로 풀어야 한다.\
// 전 문제는 동전 갯수에 제한이 없기에 중복이 가능하다
// 중복이 불가할때는 뒤에서 부터 진행한다.
// DP 즉 계속해서 값을 바꿔가는 형식 최적으로