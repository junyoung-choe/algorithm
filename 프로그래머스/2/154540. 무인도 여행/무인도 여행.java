import java.util.*;
class Solution {
    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Integer> answer = new ArrayList<>();
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] ch;
    static int height, width;
    public ArrayList<Integer> solution(String[] maps) {
        height = maps.length;
        width = maps[0].length();
        
        map = new int[height][width];
        ch = new boolean[height][width];
        
        for(int i = 0; i<height; i++) {
            maps[i] = maps[i].replaceAll("X", "0");
            System.out.println(maps[i]);
            for(int j = 0; j<width; j++) {
                map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        // print(map);
        
        int island = 0;
        for(int i = 0; i<height; i++) {
            for(int j = 0; j<width; j++) {
                if(map[i][j] == 0) continue;
                if(ch[i][j]) continue;
                BFS(i,j);
                island++;
            }
        }
        
        if(island == 0) answer.add(-1);
        else Collections.sort(answer);
        return answer;
    }
    
    public static void BFS(int x, int y) {
        Queue<Point> Q = new ArrayDeque<>();
        int sum = 0;
        
        Q.add(new Point(x,y));
        ch[x][y] = true;
        sum += map[x][y];
        
        while(!Q.isEmpty()) {
            Point now = Q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(nx >= height || nx < 0 || ny >= width || ny < 0) continue;
                if(map[nx][ny] == 0) continue;
                if(ch[nx][ny]) continue;
                
                Q.add(new Point(nx,ny));
                ch[nx][ny] = true;
                sum += map[nx][ny];
            }
        }
        answer.add(sum);
    }
    
    public static void print(int[][] map) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}