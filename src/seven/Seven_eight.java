package seven;
import java.util.*;
public class Seven_eight {
    int answer = 0;
    int[] dis = {1, -1, 5}; //이동이 가능한 숫자들
    int[] ch; // 한번 방문한 좌표는 다시 방문하면 안된다 ! 중복을 제거하여 시간을 단축시킨다.
    Queue<Integer> Q = new LinkedList<>(); // 전역으로 생성
    public int BFS(int s, int e) {
        ch = new int[10001]; // 전역 변수로 생성하기 위해서 이렇게 생성, 중복 제거를 위해 가능한 수직선상의 중복을 제거하기 위해서 1~10000 까지의 배열을 생성
        ch[s] = 1; // 이미 온적이 있다는 뜻으로 다음에 올 중복을 사전에 제거하기 위한 방
        Q.offer(s);
        int L=0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                //if(x == e) return L; // 해당 level이 즉 몇번의 과정으로 송아지한테 도달하는지에 대한 값이다.
                for (int j = 0; j < 3; j++) {
                    int nx = x+dis[j];
                    if (nx == e) return L+1; // 이렇게 하면 while 문 한번 더 도는것을 방지할수 있기에 더 효율적이다.
                    if(nx >=0 && nx <= 10000 && ch[nx]==0){
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Seven_eight T = new Seven_eight();
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.print(T.BFS(s,e));
    }
}
// 최단 거리를 구해라 -> 최단거리 알고리즘