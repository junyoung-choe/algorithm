package seven;
import java.util.*;

public class Seven_twelve {
    static int n, m, answer = 0; // n은 노드의 갯수를 나타내고 , m은 연결선의 갯수를 의미한다.
    static int[][] graph; // 노드의 연결을 나타내는 그래프 배열이다.
    static int[] ch; // 체크 배열이다
    public void DFS(int v) {
        if(v==n) answer++; // 해당한다면 여기만 들리고 끝난다 DFS 한번이
        else {
            for (int i = 0; i < n; i++) {
                if(graph[v][i] == 1 && ch[i] == 0) { // 해당 v에 나머지 연결된 노드들을 찾으면서, ch[] 들린적이 없다면 들어간다,
                    ch[i] = 1; // 들렸다고 체크를 해준다.
                    DFS(i); // 현재 스택에서 새로운 스택을 추가한다
                    ch[i] = 0; // 스택에서 나온다면 체크를 다시 빼준다.
                }
            }
        }

    }

    public static void main(String[] args) {
        Seven_twelve T = new Seven_twelve();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n+1][n+1]; // 0 인덱스는 사용하지 않는다.
        ch = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1; // 연결 들어오는것을 그래프에 추가한다. | 방향 그래프이기에 하나만 추가한다,
        }
        ch[1] = 1; // ch는 한번 다녀온 노드를 체크하는 것으로 1은 시작으로 1을 등록해놓은다.
        T.DFS(1);
        System.out.println(answer); // answer 는 전역 변수이다.
    }
}

// 경로 탐색은 한번 방문한 노드는 다시 방문하지 않는다.