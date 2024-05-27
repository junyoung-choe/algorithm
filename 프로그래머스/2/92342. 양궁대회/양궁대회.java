// 라이언이 이기고 더 큰 점수를 얻을수 있는 방법을 찾는다
// 전체를 다 DFS로 구할수 있겠지만 -> 각 점수별로 이길때 질때를 정하면 되지 않을까? 

import java.util.*;
class Solution {
    static int[] answer = new int[11];
    static int[] sel = new int[11];
    static int[] INFO = new int[11];
    static int N;
    static int max = 0;
    static int[] target = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    public int[] solution(int n, int[] info) {
        INFO = info;
        N = n;
        
        DFS(0, n);
        
        if (max == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
    
    public static void DFS(int idx, int allow) {
        // 10개의 과녁판을 다 맞췄다면 ! 
        if(idx == 10) {
            // 남은 화살을 넣는다 
            // 어차피 점수에는 반영이 되지 않고
            // 정답을 위해 남은 화살을 다 반영해야 한다 ! 
            sel[10] = allow;
            
            int score = cal();
            // 즉 지거나 비기는 경우는 pass
            if(max < score) {
                max = score;
                answer = sel.clone();
            // 점수가 같은 경우 더 낮은 과녁을 더 많이 맞춘게 정답 처리를 따로 해줘야 한다.
            } else if(max == score) {
                answer = check().clone();
            }
            return;
        }
        
        // 해당 라운드 이기는 경우 
        // 조건이 필요하다 현재 시점에서 남아있는 화살이 어피치가 해당 좌표에 맞춰논 화살보다 많이 남아 있어야 한다. 
        if(INFO[idx] < allow) {
            sel[idx] = INFO[idx] + 1;
            DFS(idx + 1, allow - (INFO[idx] + 1) );
        }
        
        // 해당 라운드 지는 경우  
        // 그냥 1발도 맞추지 않고 넘기면 된다 ! 
        sel[idx] = 0;
        DFS(idx + 1, allow);
    }
    
    public static int cal() {
        int score = 0;
        for(int i=0; i<10; i++) {
            
            // 라이언이 해당 점수는 이길 경우
            if(sel[i] > INFO[i]) {
                score += target[i];
            }
            else if(sel[i] == 0 && INFO[i] == 0) {
                continue;
            }
            // 라이언이 해당 점수는 지는 경우
            else {
                score -= target[i];
            }
        }
        return score;
    }
    
    public static int[] check() {
        for(int i=10; i>=0; i--) {
            if(sel[i] > answer[i]) {
                return sel;
            }
            else if(sel[i] < answer[i]){ 
                return answer;   
            }
        }
        return answer;
    }
}

// 1차 적으로 둘다 0 점인 경우를 간과했다.
// 2차 적으로 라이언이 이기는 경우인데 점수가 같을 경우 낮은 점수를 더 많이 맞춘게 정답이라고 한다.
// 이때 단순하게 <= 로 처리하면 된다고 생각했지만 아니였다
// 따라서 == 경우를 분리해서 아래 점수부터 살펴보는게 맞다 ! 
// 이 부분을 아주 크게 놓쳤었다.