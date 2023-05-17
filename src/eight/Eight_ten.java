package eight;
import java.util.*;
public class Eight_ten {
    static int[][] board = new int[9][9]; // 7*7 격자판에 맨 바깥쪽을 1로 만든다.
    static int[][] check = new int[9][9]; // 체크배열
    static int answer = 0;
    int[] dx = {-1, 1, 0, 0}; // 상하좌우
    int[] dy = {0, 0, -1, 1}; // 상하좌우

    public void DFS(int x, int y) {
        if (x == 7 && y == 7) answer++;
        // if(check[x][y] == 1) return;  // 체크 배열을 만들기보다 board 배열에 0을 1로 바꾸고 재귀 나오면서 다시 0으로 바꾼다.
        else if (board[x][y] == 1) return; //상하좌우 방향중 1(벽)을 만나면 해당 재귀를 끝낸다. 그냥 if 를 쓰면 안되고 else if를 써야한다.
        else {
            if(board[x][y] == 0) {
            for (int i = 0; i < 4; i++) {
                board[x][y] = 1;       // 여기 들렸다는건 현재 포인트를 지나 다음 포인트로 가겠다는 뜻이다. 지나온곳 다시 못 지나게 하기 위해서
                DFS(x + dx[i], y + dy[i]);
                board[x][y] = 0;       // 다시 0으로 바꿔준다.
                // 1로 바꾸고 다시 0 으로 바꿔도 문제가 없다 어차피 해당 재귀에 들어온 값들에서만 임의로 1로 바꾼것을 사용하기 때문이다.
            }
        }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) { // 맨 바깥쪽을 1로 초기화 시킨다. 나머지 7*7은 현재 0이다.
            board[i][0] = 1;
            board[i][8] = 1;
            board[0][i] = 1;
            board[8][i] = 1;
        }

        board[1][1] = 1; // 시작점은 들렸다고 지정해둔다.

        for (int i = 1; i < 8 ; i++) {// [1][1] ~ [7][7] 0 or 1로 지정한다. 벽과 길.
            for (int j = 1; j < 8 ; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        Eight_ten T = new Eight_ten();
        T.DFS(1,1);
        System.out.println(answer);

    }
}
// 왔던 길을 다시 돌아가면 안된다는 생각 !