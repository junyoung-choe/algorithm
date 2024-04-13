package codeTree;

import java.util.*;
import java.io.*;

public class potop {
    static class Point implements Comparable<Point> {
        int x, y, power, resent;

        public Point(int x, int y, int power, int resent) {
            this.x = x;
            this.y = y;
            this.power = power;
            this.resent = resent;
        }
        @Override
        public int compareTo(Point o) {
            if(this.power == o.power) {
                if (this.resent == o.resent) {
                    if((this.x + this.y) == (o.x + o.y)) {
                        return this.y - o.y;
                    }
                    return (this.x + this.y) - (o.x + o.y);
                }
                return this.resent - o.resent;
            }
            return o.power - this.power;
        }
    }

    public static class Remember {
        int x, y;
        ArrayList<Remember> remembers = new ArrayList<>();
        public Remember(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M, K;
    static int map[][];
    static PriorityQueue<Point> attack;
    static PriorityQueue<Point> defence;
    // 레이저는 우하좌상의 우선순위로 BFS 이다
    static int[] r_dx = {0, 1, 0, -1};
    static int[] r_dy = {1, 0, -1, 0};
    // 포탄의 8방향 공격 !
    static int[] p_dx = {-1, -1, -1 ,0, 1, 1, 1, 0};
    static int[] p_dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static boolean notHeal[][];

    static int resents[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 차례로 x, y, 횟수이다
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        resents = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // PQ 활용으로 1번 2번 완료

        for (int t=0; t<K; t++) {
            attack = new PriorityQueue<>(Collections.reverseOrder());
            defence = new PriorityQueue<>();
            notHeal = new boolean[N][M];

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(map[i][j] > 0) {
                        attack.add(new Point(i,j,map[i][j], resents[i][j]));
                        defence.add(new Point(i,j,map[i][j], resents[i][j]));
                    }
                }
            }

            Point now_at = attack.poll();
            Point now_de = defence.poll();
            map[now_at.x][now_at.y] += N + M;
            now_at.power += N + M;
            notHeal[now_at.x][now_at.y] = true;
            notHeal[now_de.x][now_de.y] = true;

            resents[now_at.x][now_at.y] = t+1;

            // 레이저 (불가능시 바로 포탄으로)
            razer(now_at, now_de);

            // 포탑 몇개 살아있는지 체크 ! 1개 이하라면 break; 2개 이상 살아있으면 true 반환 !
            if(!alive()) break;

            // 포탑 정비 +1
            plus();

//            print();
        }
        // 제일 큰 공격력 출력 ! 
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
        System.out.println(answer);
    }

    // 레이저
    public static void razer(Point now_at, Point now_de) {
        Queue<Remember> Q = new ArrayDeque<Remember>();
        boolean[][] ch = new boolean[N][M];
        boolean flag = false;
        ch[now_at.x][now_at.y] = true;
        Q.add(new Remember(now_at.x, now_at.y));

        while(!Q.isEmpty()) {
            Remember now = Q.poll();

            for(int i=0; i<4; i++) {
                int nx = now.x + r_dx[i];
                int ny = now.y + r_dy[i];

                if(nx == N) nx = 0;
                if(nx == -1) nx = N-1;
                if(ny == M) ny = 0;
                if(ny == -1) ny = M-1;

                // 죽은 포탑은 지나가지 못한다.
                if(map[nx][ny] <= 0) continue;
                if(ch[nx][ny]) continue;

                // 공격 대상을 찾았을때 ! 
                if(nx == now_de.x && ny == now_de.y) {
                    for(Remember tmp : now.remembers) {
                        map[tmp.x][tmp.y] -= (now_at.power)/2;
                        notHeal[tmp.x][tmp.y] = true;
                    }

                    map[nx][ny] -= now_at.power;
                    flag = true;
                    break;
                }

                Remember remember = new Remember(nx, ny);
                remember.remembers.addAll(now.remembers);
                remember.remembers.add(new Remember(nx, ny));

                ch[nx][ny] = true;
                Q.add(remember);
            }
            if(flag) return;
        }
        // 여기까지 왔다는건 레이저 공격 불가 ! 
        // 포탄 공격 ! 
        potan(now_at, now_de);
    }
    // 포탄
    public static void potan(Point now_at, Point now_de) {
        for(int i=0; i<8; i++) {
            int nx = now_de.x + p_dx[i];
            int ny = now_de.y + p_dy[i];

            if(nx == N) nx = 0;
            if(nx == -1) nx = N-1;
            if(ny == M) ny = 0;
            if(ny == -1) ny = M-1;

            if(map[nx][ny] <= 0) continue;
            if(nx == now_at.x && ny == now_at.y) continue;

            notHeal[nx][ny] = true;
            map[nx][ny] -= (now_at.power)/2;
        }

        map[now_de.x][now_de.y] -= now_at.power;
    }

    public static boolean alive() {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] > 0) {
                    cnt++;
                }
            }
        }

        if(cnt >= 2) return true;
        return false;
    }

    public static void plus() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] > 0 && !notHeal[i][j]) {
                    map[i][j] += 1;
                }
            }
        }
    }

    public static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}