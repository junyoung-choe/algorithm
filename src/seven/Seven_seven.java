package seven;
import java.util.*;

public class Seven_seven {
    Node root;      // 루트 노드의 래퍼런스.

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root); // root 값 즉 1을 넣는다.
        int L=0;
        while (!Q.isEmpty()) {
            int len=Q.size();
            System.out.print(L + " : "); // L 즉 레벨을 의미한다,
            for(int i=0; i<len; i++){  // 현재 계층의 값들은 뽑아내며 자식 노드들은 큐에 넣는다.
                Node cur = Q.poll(); // 해당 계층의 값을 뽑아낸다.
                System.out.print(cur.data+ " ");
                if(cur.lt != null) Q.offer(cur.lt); // 자식이 있다는 뜻
                if(cur.rt != null) Q.offer(cur.rt);
            } // 각 레벨의 노드 명을 출력한다,
            L++;  // L 은 레벨이자 얼마나 움작여서 값을 찾냐는 의미도 가지고 있다.
            System.out.println();
    }
}

    public static void main(String args[]) {
        Seven_seven tree = new Seven_seven();   // 루트 노드의 래퍼런스를 불러온다.
        tree.root = new Node(1);          // 번호 1번인 노드 객체 생성.
        tree.root.lt = new Node(2);       // 이 과정은 그냥 값을 지정하는 상황이라고 보면 된다.
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
// 이진트리 순회(넓이우선탐색 : 레벨 탐색) 루트 노드에서 간선이 몇개 있냐에 따라서 level이 정해진다.