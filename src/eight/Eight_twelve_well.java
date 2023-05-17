package eight;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Eight_twelve_well {
    static int m , n; //m = 가로, n = 세로
    static int[][] box, dis;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static Queue<Point> queue = new LinkedList<>(); // 전역 잡은 이유는 초기값 즉 1을 main 문에서 찾아서 넣어놔야 하기 때문이다.
    public void BFS() {
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int X = tmp.x + dx[i];
                int Y = tmp.y + dy[i];
                if (X >=0 && X < n && Y >=0 && Y < m && box[X][Y] == 0 ){
                    box[X][Y] = 1;
                    queue.offer(new Point(X,Y));
                    dis[X][Y] = dis[tmp.x][tmp.y] + 1; // 최소 경로 or 날짜를 위해 넘어온 레벨 (현재 객체의 x,y) (dis[x][y]의) 값에서 에서 +1 한다
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        box = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = scanner.nextInt();
                if (box[i][j] == 1) queue.offer(new Point(i, j)); // 처음 큐 값을 지정한다.
            }
        }
        scanner.close();

        Eight_twelve_well T = new Eight_twelve_well();
        T.BFS();
        boolean flag = true; // 안익은 과일(0값) 있는지 확인하기 위해서
        int answer = Integer.MIN_VALUE; // 최대 일자의 익은 과일을 확인하기 위해서

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) flag = false;
            }
        }

        if (flag) { // 안 익은 과일이 없다면
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        }
        else answer = -1;

        System.out.println(answer);
    }
}
// BFS size로 범위를 정해놓았기에 한 단계 내에서 큐 뒤에 쌓이는건 다음 단계에서 진행한다 !
// 내가 직접 좌표를 가지고 하는게 아니기에 인덱스에 맞출 필요가 없이 그냥 n, m 사용한다.