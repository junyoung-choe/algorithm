package seven;

public class Seven_four_good {
    static int[] fibo;    // 재귀로 호출시 각 메소드 내부에서 공통으로 사용하기 위해서 전역변수이자 static 으로 선언
    public int DFS(int n) {
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-1) + DFS(n-2);   // 트리의 한쪽으로만 쭉 내려간다면 겹치지 않는 한줄을 구할수 있다.
        // 이렇게 fibo 한번 거치면 값을 저장하며 리턴할수 있고 n의 숫자가 겹쳐도 같은값이기에 상관이 없다.
    }

    public static void main(String[] args) {
        Seven_four_good T = new Seven_four_good();
        int n =10;
        fibo = new int[n+1]; // 0번 인덱스를 사용하지 않기 위해서.
        T.DFS(n); // 10 넣는다. 트리를 한번만 생성한다 메모리 효율적
        for (int i = 0; i <= n; i++) System.out.print(fibo[i] + " ");

    }
}
// for 문을 돌리면 수많은 트리들이 생성된다.
// 따라서 DFS 안에서 해결한다면 더 좋다 1~n 까지의 값들을
// 한개의 트리만 생성해서 돌리기에 앞에꺼보다 효율적
