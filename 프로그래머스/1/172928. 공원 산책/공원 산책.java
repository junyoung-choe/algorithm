import java.io.*;
import java.util.*;

class Solution {
    static int[][] map;
    static int H, W;
    static int n_x, n_y;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        H = park.length;
        W = park[0].length();
        
        map = new int[H][W]; 
        
        // init
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                map[i][j] = park[i].charAt(j);
                // 초기 좌표 세팅
                if(map[i][j] == 'S') {
                    n_x = i;
                    n_y = j;
                }
            }
        }
        
        move(routes);
        
        answer[0] = n_x;
        answer[1] = n_y;
        
        return answer;
    }
    // 메인 함수 (이동)
    public void move(String[] routes) {
        for(String route : routes) {
            
            // 방향과 이동수
            char dir = route.charAt(0);
            int step = route.charAt(2) - '0';
            
            // 한칸씩 이동할 좌표
            int t_x = n_x;
            int t_y = n_y;
            
            // + 될 좌표
            int p_x = 0, p_y = 0;
            switch(dir) {
                // 상 우 하 좌
                case 'N': 
                    p_x = -1;
                    p_y = 0;
                    break;
                case 'E': 
                    p_x = 0;
                    p_y = 1;
                    break;
                case 'S': 
                    p_x = 1;
                    p_y = 0;
                    break;
                case 'W': 
                    p_x = 0;
                    p_y = -1;
                    break;
            }
            
            // 벽을 만나거나 장애물을 만났을때 사용하는 깃발
            boolean flag = false;
            
            for(int i=0; i<step; i++) {
                t_x += p_x;
                t_y += p_y;
                if( t_x >= H || t_x < 0 || t_y >= W || t_y < 0 || map[t_x][t_y] == 'X') {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            
            n_x = t_x;
            n_y = t_y;
        }
    }
    
}