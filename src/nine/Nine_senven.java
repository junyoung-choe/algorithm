package nine;
import java.util.*;

class Edge1 implements Comparable<Edge1>{
    public int v1;
    public int v2;
    public int cost;
    Edge1(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge1 ob){
        return this.cost-ob.cost;   // 오름차순으로 정렬한다.
    }
}

class Nine_seven {
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        unf=new int[n+1];
        ArrayList<Edge1> arr=new ArrayList<>();
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            arr.add(new Edge1(a, b, c));
        }
        int answer=0;
        Collections.sort(arr);
        for(Edge1 ob : arr){
            int fv1=Find(ob.v1);
            int fv2=Find(ob.v2);
            if(fv1!=fv2){ // 같은 원소가 아니라면 !
                answer+=ob.cost; // 총 비용을 더하구
                Union(ob.v1, ob.v2); // 두개를 같은 원소로 만들어준다 !
                // cnt++ 해서 간선이 n-1 됬다면 끝낸다면 효율이 더 좋아진다 !
            }
        }
        System.out.println(answer);
    }
}

// 최소 스패닝 트리 -> 그래프의 최소 간선 + 최소 가중치 을 이야기한다.
// 그래프는 연결되어 돌아오는 것이 있는 원(회로)의 형태이고 그래프는 간선의 갯수가 훨신더 많을수 있다.
// 트리는 정점이 n 개라면 -> 간선은 n-1 개이다.
// 최소 스패닝 트리를 구하기 위해서 크루스칼, Union&Find를 활용 해야한다 !
// 원소가 되어있는 것들을 연결하면 회로가 되버린다. -> 회로를 탈피해야 한다.
// 회로가 안되는 상황에서 작은 값부터 하나씩 골라서 나간다.