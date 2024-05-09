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
// 간선을 하나씩 ban 시키면서 차이값을 구하면서 풀었다 !

// 게리 멘더링과 문제를 구분하는게 중요했다 !

// 트리의 성질 또한 중요했다


// import java.io.*;
// import java.util.*;
// class Solution {
//     static ArrayList<ArrayList<Integer>> arr;
//     static int[] sel;
//     static int answer;
//     static int N;
//     public int solution(int n, int[][] wires) {
//         answer = Integer.MAX_VALUE;
//         N = n;
//         // 그룹 나누기
//         sel = new int[n+1];

//         // 인접 리스트 구현
//         arr = new ArrayList<ArrayList<Integer>>();
//         for(int i=0; i<=n; i++) {
//             arr.add(new ArrayList<Integer>());
//         }

//         // 인접 리스트 연결
//         for(int i=0; i<n-1; i++) {
//             arr.get(wires[i][0]).add(wires[i][1]);
//             arr.get(wires[i][1]).add(wires[i][0]);
//         }
//         Combi(1);

//         return answer;
//     }

//     // 1번 노드부터 N번 노드들을 전부 1그룹 or 2그룹으로 배정한다
//     public static void Combi(int idx) {
//         if(idx == N+1) {
//             cal();
//             return;
//         }

//         sel[idx] = 1;
//         Combi(idx + 1);
//         sel[idx] = 2;
//         Combi(idx + 1);
//     }
//     static boolean[] ch;
//     public static void cal() {
//         ch = new boolean[N+1];
//         int cnt = 0;

//         for(int i=1; i<=N; i++) {
//             if(ch[i]) continue;

//             cnt++;
//             BFS(i, sel[i]);

//             if(cnt == 3) return;
//         }

//         // 정답 후보들의 케이스
//         if(cnt == 2) {
//             int one = 0;
//             int two = 0;

//             for(int i=1; i<=N; i++) {
//                 if(sel[i] == 1) one += 1;
//                 else two += 1;
//             }

//             answer = Math.min(answer, Math.abs(one - two));
//         }
//     }

//     public static void BFS(int idx, int group) {
//         Queue<Integer> Q = new ArrayDeque<>();
//         Q.add(idx);

//         while(!Q.isEmpty()) {
//             int now = Q.poll();

//             for(int i=0; i<arr.get(now).size(); i++) {
//                 int next = arr.get(now).get(i);

//                 if(sel[now] != sel[next]) continue;
//                 if(ch[next]) continue;

//                 ch[next] = true;
//                 Q.add(next);
//             }
//         }
//     }
// }

// N 이 100개이므로 2^100 이라는 조합을 구분하는 시간이 든다 !
// 따라서 이렇게 푸는것이 아니다 !

// 게리 맨더링
// 게리 멘더링이랑 조금 다른 문제이다
// 게리 맨더링은 간선은 그대로 두고 그룹을 나눈 문제이고
// 이 문제는 간선을 임의로 하나 제거하는 문제이다 !
// 또한 n의 조건은 최대 10이기에 모든 조합을 뽑는것이 가능하다

// 이 문제에서는 한개의 간선이 끊기면 반드시 두개의 그룹으로 분리된다 !
// 이 부분을 착안하여 다시 풀어보려고 한다.