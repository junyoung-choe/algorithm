package eight;
import java.util.*;

public class Eight_thirteen {
    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0 ,-1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void DFS(int x, int y) {
        board[x][y] = 0;
        for (int i=0; i<8; i++) {
            if (board[x+dx[i]][y+dy[i]] == 1) {
                DFS(x+dx[i], y+dy[i]);
            }
        }
    }

    public static void main(String[] args) {
        Eight_thirteen T = new Eight_thirteen();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        board = new int[n + 2][n + 2]; // 가장 바깥쪽 테두리는 0으로 고정한다. | 인덱스는 0 ~ n+1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    T.DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
