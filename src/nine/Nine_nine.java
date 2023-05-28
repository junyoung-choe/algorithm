package nine;

import java.util.*;
class Edge2 implements Comparable<Edge2>{
    public int vex;
    public int cost;
    Edge2(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge2 ob){
        return this.cost-ob.cost;
    }
}
class Nine_nine {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        ArrayList<ArrayList<Edge2>> graph = new ArrayList<ArrayList<Edge2>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge2>());
        }
        int[] ch=new int[n+1];
        for(int i=0; i<m; i++){ // 인접리스트를 제작한다 !
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            graph.get(a).add(new Edge2(b, c)); // 무방향이기에 a -> b
            graph.get(b).add(new Edge2(a, c)); // b -> a 두개다 설계한다
        }
        int answer=0;
        PriorityQueue<Edge2> pQ = new PriorityQueue<>();
        pQ.offer(new Edge2(1, 0)); // 임으로 1번 정점에서 출발하기에 이렇게 시작한다 !
        while(!pQ.isEmpty()){
            Edge2 tmp=pQ.poll();
            int ev=tmp.vex;
            if(ch[ev]==0){ // 회로가 되는것을 방지한다 ! ( n-1개의 간선만 만들겠다 )
                ch[ev]=1;
                answer+=tmp.cost;
                for(Edge2 ob : graph.get(ev)){
                    if(ch[ob.vex]==0) pQ.offer(new Edge2(ob.vex, ob.cost));
                } // 나에게로 뻗어온 노드에게 다시 돌아가지 않겠다 !
            }
        }
        System.out.println(answer);
    }
}
// 이미 회로가 된 상태에서 트리를 구하는 문제라는걸 기억하자
// 그러니 그리디로 작은것만 뽑는다!
// 꼭 현재 노드에서의 간선이 연결되는 것이 아니다
// 전 노드에서 갈수있었던 간선이 연결될수도 있다 !