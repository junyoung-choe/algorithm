package seven;

public class Seven_six {
    static int n; // static인 이유는 main 문에서 사용해야 하기 때문이다. 밑에 DFS 사용할수 있는 이유는 같은 {} 안에 있다.
    static int[] ch;
    public void DFS(int L){
        if(L==n+1) {
            String tmp= "";
            for (int i = 0; i <= n; i++) {
                if (ch[i]==1) tmp+=(i+" ");
            }
            if (tmp.length()>0) System.out.println(tmp); // 공집합이 아닐때 출력한다.
        }
        else {
            ch[L] = 1; // 해당 원소 or 숫자(L)를 사용한다,
            DFS(L+1); // 왼쪽이라고 생각하자
            ch[L] = 0; // 원소를 사용하지 않는다.
            DFS(L+1); // 오른쪽이라고 생각하자
        }

    }

    public static void main(String[] args) {
        Seven_six T = new Seven_six();
        n=3;
        ch = new int[n+1]; // 체크를 인덱스 번호로 사용하기에 n 보다 1큰 배열을 사용한다. | [1,2,3] 다 0으로 초기화 된다.
        T.DFS(1);
    }

}
// 2^n -> 갯수에서 -1
// DFS, 백트래킹, 재귀함수를 이용 -> 트리를 분석해서 공부해야한다.