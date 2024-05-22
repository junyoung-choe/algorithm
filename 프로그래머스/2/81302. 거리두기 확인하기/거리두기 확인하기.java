// 각 사용자마다 벽 못뚤고 책상들을 지나며 
// 다른 사용자 만나면 0 출력 ! 
// BFS 탐색이 필요하다 ! 
// 맨허튼 거리는 즉 2칸을 이동했을때이다 ! 
import java.util.*;
class Solution {
    static class Point {
        int x, y, cnt;
        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int dx[] = {-1, 0 ,1, 0};
    static int dy[] = {0, 1, 0, -1};
    static char[][] map;
    public ArrayList<Integer> solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<5; i++) {
            map = new char[5][5];
            for(int j=0; j<5; j++) {
                String str = places[i][j];
                for(int l=0; l<5; l++) {
                    map[j][l] = str.charAt(l);
                }
            }
            print(map);
            //BFS
            boolean flag = false;
            loop:
            for(int j=0; j<5; j++) {
                for(int l=0; l<5; l++) {
                    if(map[j][l] == 'P') {
                        // 만약 지켜지지 않았다면 ! 
                        if(BFS(j,l)) {
                            System.out.println("하나 올리고~");
                            answer.add(0);
                            flag = true;
                            break loop;
                        }            
                    } 
                }
            }
            if(!flag) {
                answer.add(1);
            }
            System.out.println("하나는 끝~");
        }
        return answer;
    }
    
    public static boolean BFS(int x, int y) {
        boolean ch[][] = new boolean[5][5];
        Queue<Point> Q = new ArrayDeque<>();
        
        Q.add(new Point(x,y,0));
        ch[x][y] = true;
        
        while(!Q.isEmpty()) {
            Point now = Q.poll();
            if(now.cnt == 2) continue;
            
            for(int i=0; i<4; i++) {
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                
                if(nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                if(ch[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;
                if(map[nx][ny] == 'P') return true;
                
                ch[nx][ny] = true;
                Q.add(new Point(nx,ny,now.cnt+1));
            }
        }
        return false;
    }
    
    public static void print(char[][] map) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}