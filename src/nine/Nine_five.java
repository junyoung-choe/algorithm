package nine;

import java.util.*;
class Edge implements Comparable<Edge>{
    public int vex;
    public int cost;
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost-ob.cost;
    }
}

class Nine_five {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    public void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        // PriorityQueue 는 Collections.sort() 필요없이 원래는 오름차순이 기본이고 new PriorityQueue<>(Collections.reverseOrder()); 선언시 내림차순이지만
        // 객체를 정렬해야 하기때문에 compareTo를 써놓구 그에 해당하는 정렬이 진행된다.

//        Queue<Edge> Q = new LinkedList<>();
//        Collections.sort(Q);
//        Comparable 은 Queue 에서는 사용하지 않는다.

        // 오름차순으로 정렬
        // Collections.sort(list);
        //
        // 내림차순으로 정렬
        // Collections.sort(list, Collections.reverseOrder());
        // ArrayList 객체 없이 정렬시에는 위처럼 간편하게 가능하다.

        pQ.offer(new Edge(v, 0));
        dis[v]=0;
        while(!pQ.isEmpty()){
            Edge tmp=pQ.poll();
            int now=tmp.vex;
            int nowCost=tmp.cost;
            if(nowCost>dis[now]) continue; // 원래 노드의 dis 값보다 돌아서 온 노드의 현재 가중치가 크다면 굳이 볼필요가 없다 같은 방향으로 가지만 가중치가 더 크기 때문이다.
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex]>nowCost+ob.cost){
                    dis[ob.vex]=nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }

    public static void main(String[] args){
        Nine_five T = new Nine_five();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis=new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        T.solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i]!=Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }
    }
}
// 디익스트라 알고리즘 -> 가중치에 음수가 없다는 가정으로 시작한다.
// Integer.MAX_VALURE 로 dis[] 를 모두 초기화 시킨다
// 인접 리스트 방법으로 만들고
// 방향과 가중치가 모두 존재하기에 맞게 풀어준다.
// 한 노드에서 뻗어간 다음 노드들 중 1개만 선택해 최소값을 계속해서 확정해 나가는 방식이다. -> greed 기법이다.