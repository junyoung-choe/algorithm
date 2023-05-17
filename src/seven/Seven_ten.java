package seven;
import java.util.*;
public class Seven_ten {
    Node root;
    public int BFS(Node root){ // root 는 계속해서 들어오는 노드이다.
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if(cur.lt == null && cur.rt == null) return L;
                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;
        }
        return 0; // 에러 방지용

    } 


    public static void main(String[] args) {
        Seven_ten tree = new Seven_ten();   // 루트 노드의 래퍼런스를 불러온다.
        tree.root = new Node(1);          // 번호 1번인 노드 객체 생성.
        tree.root.lt = new Node(2);       // 이 과정은 그냥 값을 지정하는 상황이라고 보면 된다.
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        System.out.println(tree.BFS(tree.root));
    }
}
// 레벨 탐색으로 수평적으로 탐색하기에 자식의 노드의 갯수가 중요하지 않다는 장점이 존재한다
// 너비 우선 탐색을 구현할때는 큐가 필요하다는 생각 !