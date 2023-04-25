package two;
import java.util.*;
public class Two_twelve {

    public int solution(int n, int m, int[][] rank){
        int answer = 0;
        for (int i = 1; i <= n; i++) {     // 실제 배열에 학생들의 숫자가 1~4까지 있기에 위에서 맞춰주는것!
            for (int j = 1; j <= n; j++) { //  2중 for문 학생수 x 학생수 모든 경우의 수를 가지고있다.
                int cnt = 0;               // 여기 밑에서만 사용하고 이 시점에서 초기화도 요구된다.
                for (int k = 0; k < m; k++) { // 3번째, 4번째 for문은 배열을 확인한다.
                    int pi=0, pj=0;   // 밑 포문에서만 사용하고 끝나면 초기화가 필요하기에 여기다가 넣는다.
                    for (int l = 0; l < n; l++) {
                        if (rank[k][l]==i) pi = l; // 즉 0~3번의 등수를 넣는것이다.
                        if (rank[k][l]==j) pj = l;
                    }
                    if(pi<pj) cnt++;                // 한 행에서 높을때마다 +1 해준다.
                }
                if(cnt==m){
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 학생 수
        int m = scanner.nextInt(); // 테스트 횟수
        int[][] rank = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rank[i][j] = scanner.nextInt();
            }
        }
        Two_twelve T = new Two_twelve();
        System.out.println(T.solution(n,m,rank));
    }
}

// 이런 문제를 풀때 우선 모든 경우의 수를 생각하고 그 경우중에 원하는 결과만 고른다는 생각으로 접근하기
// 4중 for 문을 사용한다. 이러한 메커니즘에 대해서 이해하기 !
