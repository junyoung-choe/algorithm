package seven;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Seven_fourteen {
    static ArrayList<ArrayList<Integer>> graph;
    static int n, m; // n은 노드의 갯수를 나타내고 , m은 연결선의 갯수를 의미한다.
    static int[] ch, dis; // 체크 배열과, 거리 배열을 제작한다.
    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>(); // 너비 우선 탐색 여기서 만든다.
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll(); // cv 현재 값이라는 뜻
            for(int nv : graph.get(cv)) {
                if (ch[nv] == 0) { // 방문 안했냐?
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;  // 이원리가 중요하다
                }
            }
        }
    }
    public static void main(String[] args) {
        Seven_fourteen T = new Seven_fourteen();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a= scanner.nextInt();
            int b= scanner.nextInt();
            graph.get(a).add(b);
        }
        T.BFS(1); // 너비 우선 탐색
        for (int i = 2; i < n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
// BFS -> 최단거리를 나타낸다.
// 1차원에서는 L로 레벨로 BFS 많이 사용하지만.
// 2차원 배열부터는 dis[] 로 dis[] = dis[]+1 로 많이 사용한다. 이문제는 1차원이지만 연습