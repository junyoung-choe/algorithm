// 두개의 그룹으로 나눴을때 노드가 가지고있는 값의 합 차가 가장 적은거 ! 
// 1. 두개의 그룹으로 나눈다 (모든 경우)
// 2. 각 각의 그룹이 한 그룹에 속할수 있을때 !
// 3. 차이값을 구한다
import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> arr;
    static int answer;
    static int N;
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        N = n;
        // 그룹 나누기
        
        // 인접 리스트 구현
        arr = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        
        // 인접 리스트 연결 (n-1 개)
        for(int i=0; i<n-1; i++) {
            arr.get(wires[i][0]).add(wires[i][1]);
            arr.get(wires[i][1]).add(wires[i][0]);
        }
        
        // 하나의 간선을 ban 시키고 1번 노드에서 시작해 몇개의 노드를 지나치는지 구하자 
        // 그후 N 에서 빼면 된다 ! 
        for(int i=0; i<n-1; i++) {
            BFS(1, wires[i][0], wires[i][1]);
        }
        return answer;
    }
    
    
    public static void BFS(int idx, int a, int b) {
        int cnt = 1;
        Queue<Integer> Q = new ArrayDeque<>();
        boolean[] ch = new boolean[N+1];
        
        ch[idx] = true;
        Q.add(idx);
        
        while(!Q.isEmpty()) {
            int now = Q.poll();
            
            for(int i=0; i<arr.get(now).size(); i++) {
                int next = arr.get(now).get(i);
                
                if(a == now && b == next) continue;
                if(b == now && a == next) continue;
                if(ch[next]) continue;
                
                ch[next] = true;
                Q.add(next);
                cnt++;
            }
        }
        int sub = Math.abs((N - cnt) - cnt);
            
        answer = Math.min(answer, sub);
        
    }
}