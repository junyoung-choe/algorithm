package seven;

import java.util.*;

public class Seven_thirteen {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph; // 인티저 자료형을 저장하는 어레이 리스트를 저장하는 어레이 리스트이다. 전역으로 사용하기 위해서 여기서 래퍼런스 생성
    static int[] ch; // 체크 배열
    public void DFS(int v) {
        if(v==n) answer ++;
        else {
            for (int nv : graph.get(v)) {       // v번 어레이 리스트를 가져온다. 포 이치가 좋다 컬렉션 다룰때
                if(ch[nv] == 0) { // 방문한적이 없냐?
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Seven_thirteen T = new Seven_thirteen();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(); // 객체를 생성
        for (int i = 0; i <= n; i++) { // 0번 인덱스는 사용하지 않는다.
            graph.add(new ArrayList<Integer>()); // 인티저를 저장하는 어레이 리스트를 만들어서 어레이리스트에 넣는다.| 인덱스는 0부터 | 이해 중요하다.
        }
        ch = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b); // 인덱스에 접근하기 위해서 a 인덱스에 b 라는 값들을 저장한다.
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);

    }
}

// 전 문제 인접행렬은 조금 비효율적이다.
// n이 커진다면 효율적이지 않기 대문에 n*n이 된다.
// 인접 리스트 -> 인접 행렬의 문제점을 해결한다.
// 1번 리스트부터 5번 리스트까지 제작한다.
// 원수가 들어올때 리스트를 연결한다. -> 리스트를 보면 어디어디 갈수있는지 적어놓은것 | 순서를 나타낸것이 아니다 주의하기 !
//  -> ch[] 가 필요없다. for도 없어 메모리 낭비를 줄인다.
// ArrayList만 확인하면 되기에 효율적이다.