import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
        
        for(int tmp : scoville) {
            PQ.add(tmp);
        }
        
        while(true) {
            if(PQ.peek() >= K) break;
            if(PQ.size() <= 1) return -1;
            
            int a = PQ.poll();
            int b = PQ.poll();
            
            PQ.add(a + (b * 2));
            answer++;
        }
        return answer;
    }
}

