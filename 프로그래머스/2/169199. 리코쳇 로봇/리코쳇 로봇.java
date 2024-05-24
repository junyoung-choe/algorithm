import java.util.*;

class Solution {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int height, width;
    static int answer;
    
    public int solution(String[] board) {
        answer = Integer.MAX_VALUE;
        height = board.length;
        width = board[0].length();
        
        map = new char[height][width];
        int s_x = 0;
        int s_y = 0;
        
        for(int i=0; i < height; i++) {
            String str = board[i];
            for(int j=0; j < width; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R') {
                    map[i][j] = '.';
                    s_x = i;
                    s_y = j;
                }
            }
        }
        
        BFS(s_x, s_y);
        if(answer == Integer.MAX_VALUE) answer = -1;
            
        return answer;
    }
    
    public void BFS(int s_x, int s_y) {
        boolean[][] ch = new boolean[height][width];
        Queue<Point> Q = new ArrayDeque<>();
        int L = 0;
        
        Q.add(new Point(s_x, s_y));
        ch[s_x][s_y] = true;
        
        while(!Q.isEmpty()) {
            L++;
            int len = Q.size();
            for(int i=0; i<len; i++) {
                Point now = Q.poll(); 
                // System.out.println("now.x=" + now.x + "now.y=" + now.y);
                
                for(int j=0; j<4; j++) {
                    int x = now.x;
                    int y = now.y;
                    while(true) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if(nx >= height || nx < 0 || ny >= width || ny < 0) break;
                        if(map[nx][ny] == 'D') break;
                        x = nx;
                        y = ny;
                    }
                    // System.out.println("x=" + x + "y=" + y);
                    // if(now.x == x && now.y == y) continue;
                    // int nx = now.x + dx[j];
                    // int ny = now.y + dy[j];
                    // if(nx >= height || nx < 0 || ny >= width || ny < 0) continue;
                    // if(map[nx][ny] == 'D') continue;
                    
                    if(ch[x][y]) continue;
                    if(map[x][y] == 'G') {
                        answer = L;
                        return;
                    }
                    Q.add(new Point(x, y));
                    ch[x][y] = true;
                }
                // System.out.println("----------------");
            }
        }
    }
}