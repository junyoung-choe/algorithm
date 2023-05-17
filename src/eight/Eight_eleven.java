package eight;

import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Eight_eleven {
    static int[][] board = new int[9][9]; // 7*7 격자판에 맨 바깥쪽을 1로 만든다.
    static int[][] check = new int[9][9]; // 체크배열 // 그냥 원래 보드 배열에 값을 바꿔도 괜찮다.
    int[] dx = {-1, 1, 0, 0}; // 상하좌우
    int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int L=1;

    public int BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y)); // 처음 값을 넣는다.

        while (!queue.isEmpty()) {

            for (int k = 0; k < queue.size(); k++) {
                Point p = queue.poll(); //큐의 객체를 하나씩 뽑는다.
                if (check[p.x][p.y] == 1) continue;

                for (int i = 0; i < 4; i++) { // 꺼낸 하나의 객체 즉 현재의 경로에서 다음 경로를 탐색해 큐에 넣는다.
                    check[p.x][p.y] = 1;
                    if (board[p.x + dx[i]][p.y + dy[i]] == 0) { // 큐에서 꺼낸 객체 현재 위치에서 상하좌우 중에 진행로(0) 있을때만 진행한다. (다음 노드를 생성한다)
                        queue.offer(new Point(p.x + dx[i], p.y + dy[i])); // 재귀를 실행하지 않고 큐에 넣어놓기만 한다 -> BFS
                        if (p.x == 7 && p.y == 7) return L; // 정답 나온 경우
                    }
                }
            }

            L++; // 계층을 하나씩 증가시킨다.
        }

        return L; // 오류 방지
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) { // 맨 바깥쪽을 1로 초기화 시킨다. 나머지 7*7은 현재 0이다.
            board[i][0] = 1;
            board[i][8] = 1;
            board[0][i] = 1;
            board[8][i] = 1;
        }

        for (int i = 1; i < 8; i++) {// [1][1] ~ [7][7] 0 or 1로 지정한다. 벽과 길.
            for (int j = 1; j < 8; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        Eight_eleven T = new Eight_eleven();
        T.BFS(1, 1);
        System.out.println(L);

    }
}
// BFS 재귀를 안쓴다 !
// 선생님이 푼 풀이법도 한번 보면 좋다.