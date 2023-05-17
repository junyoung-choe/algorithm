package eight;
import java.util.*;

//class Point {
//    int x, y;
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class Eight_twelve {

    static int m , n; //m = 가로, n = 세로
    static int[][] box;
    int[] dx = {-1, 1, 0, 0}; // 상하좌우
    int[] dy = {0, 0, -1, 1}; // 상하좌우

    static int answer = 0; // 날짜
    public void BFS() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) // 초기 상태에서 익은 토마토의 좌표를 찾는다.
                    queue.offer(new Point(i, j));
            }
        }

        while (!queue.isEmpty()) {
            answer++; // 하루씩 증가한다.
            for (int k = 0; k < queue.size(); k++) { // 큐 갯수만큼 진행한다.
                Point p = queue.poll();

                for (int i = 0; i < 4; i++) {// 상하좌우
                    if (p.x + dx[i] > -1 && p.y + dy[i] > -1 && p.x + dx[i] < n && p.y + dy[i] < m && box[p.x + dx[i]][p.y + dy[i]] == 0) {
                        queue.offer(new Point(p.x + dx[i], p.y + dy[i]));
                        box[p.x + dx[i]][p.y + dy[i]] = 1; // 0 익지 않은 토마토를 1 익은 토마토로 변경
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        Eight_twelve T = new Eight_twelve();
        T.BFS();

        System.out.println(answer-1); // 다 1이 된날에 확인해보니 이게 했갈리니 dis[][] 배열로 몇일째에 만들어졌는지 기록하는게 좋다 2차원 배열에서는
    }
}
