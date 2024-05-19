import java.util.*;
class Solution {
    static ArrayList<Integer> answer;
    static int[][] map;
    public ArrayList<Integer> solution(int rows, int columns, int[][] queries) {
        answer = new ArrayList<Integer>();
        
        int cnt = 1;
        
        map = new int[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                map[i][j] = cnt;
                cnt++;
            }
        }
        
        for(int[] q : queries) {
            turn(q[0]-1,q[1]-1,q[2]-1,q[3]-1);
            // print(map);
        }
        
        return answer;
    }
    // 하 우 상 좌
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void turn(int s_x, int s_y, int e_x, int e_y) {
        int min = map[s_x][s_y];
        int remember = map[s_x][s_y];
        
        int now_x = s_x;
        int now_y = s_y;
        int dir = 0;
        while(dir < 4) {
            int next_x = now_x + dx[dir];
            int next_y = now_y + dy[dir];
            if(next_x > e_x || next_x < s_x || next_y > e_y || next_y < s_y) {
                dir++;
                continue;
            }
            map[now_x][now_y] = map[next_x][next_y];
            min = Math.min(map[next_x][next_y], min);
            now_x = next_x;
            now_y = next_y;
        }
        map[s_x][s_y+1] = remember;
        
        
        answer.add(min);
    }
    
    public static void print(int[][] map) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
    
}