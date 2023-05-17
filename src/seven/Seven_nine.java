package seven;
import java.util.*;
public class Seven_nine {
    Node root;
    public int DFS(int L, Node root){ // root 는 계속해서 들어오는 노드이다.
        if(root.lt == null && root.rt == null) return L;
        else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));

    }


    public static void main(String[] args) {
        Seven_nine tree = new Seven_nine();   // 루트 노드의 래퍼런스를 불러온다.
        tree.root = new Node(1);          // 번호 1번인 노드 객체 생성.
        tree.root.lt = new Node(2);       // 이 과정은 그냥 값을 지정하는 상황이라고 보면 된다.
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        System.out.println(tree.DFS(0 ,tree.root));
    }
}
// 이문제는 사실 BFS 로 푸는것이 더 맞다 ( 최단 경로이기애)
// DFS 는 자식의 갯수가 다들 동일해야지 에러가 나지 않는다.