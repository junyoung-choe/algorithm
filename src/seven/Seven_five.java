package seven;
class Node { // 각 노드에 data 노드의 번호, lt 왼쪽 자식 주소, rt 오른쪽 자식의 주소를 가지고 있다.
    int data; // 노드의 번호
    Node lt, rt; // lt, rt 래퍼헌스 생성 , 자식들의 객체 주소를 저장하기 위해서 제작 | 즉 주소를 가리키기 위해서 레퍼런스를 만들었다.
    public Node(int val) {  // 생성자 val에 1~n 숫자들이 들어온다.
        data = val;
        lt=rt=null;
    }
}
public class Seven_five {
    Node root;      // 루트 노드의 래퍼런스.
    public void DFS(Node root){
        if(root == null) return; // 노드가 root 노드이면 종료한다.
        else {
            //System.out.print(root.data+" ");  // 전위 순회
            DFS(root.lt); // 재귀가 돌때마다 원래의 root.rt.lt 에 .lt 가 추가된다고 생각하면 쉽다.
            //System.out.print(root.data+" "); // 중위 순회
            DFS(root.rt);
            System.out.print(root.data+" "); // 후위 순회

        }
    }
    public static void main(String args[]) {
        Seven_five tree = new Seven_five();   // 루트 노드의 래퍼런스를 불러온다.
        tree.root = new Node(1);          // 번호 1번인 노드 객체 생성.
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}

// 이진 트리 기본 구조는 부모 한명에 자식 두명
// root 노드는 맨 위에 노드(원)
// 이진트리 순회(깊이 우선 탐색) 3가지 종류가 exist
// 전위순회 맨 왼쪽부터 쭉 다녀온다 부모 -> 왼쪽 자식 -> 오른쪽 자식
// 중위순회        (맨 아래의) 왼쪽 자식 -> 부모 -> 오른쪽 자식
// 후위순회        (맨 아래의) 왼쪽 자식 -> 오른쪽 자식 -> 부모  -> 병합정렬에 많이 사용한다.
