package eight;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point1 {
    int x, y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Eight_fourteen {

    static int answer = 0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void BFS(int x, int y, int[][] board) {

        Queue<Point1> queue = new LinkedList<>();
        queue.offer(new Point1(x, y));

        while (!queue.isEmpty()) {
            int length = queue.size();   // 이 문제에서는 몇단계의 BFS를 진행했는지 알 필요가 없기 때문에 없어도 무방하다
            for (int t = 0; t < length; t++) {
                Point1 p = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        queue.offer(new Point1(nx, ny));
                    }
                }
            }
        }
    }

    public void solution(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Eight_fourteen T = new Eight_fourteen();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}

