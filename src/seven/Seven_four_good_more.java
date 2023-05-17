package seven;

public class Seven_four_good_more {
    static int[] fibo;
    public int DFS(int n) {
        if (fibo[n]>0) return fibo[n];// 처음에 0 으로 초기화가 되어있다. 따라서 0보다 크면 값이 존재한다는 뜻이다. 이게 메모이 제이션이다.
        if(n==1) return fibo[n] = 1;
        else if(n==2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-1) + DFS(n-2);
    }

    public static void main(String[] args) {
        Seven_four_good_more T = new Seven_four_good_more();
        int n =10;
        fibo = new int[n+1];
        T.DFS(n);
        for (int i = 0; i <= n; i++) System.out.print(fibo[i] + " ");
    }
}

// 한쪽 트리에서 DFS(3)을 이미 구한 이력이 있다면 fibo[3]에 해당 리턴값이 저장되어 있고
// fibo 값을 가져다가 사용한다면 한 스택에 다녀오는 것을 축소할수있다.
// 만약 숫자가 커져서 DFS(10)을 알고있다면 수 많은 스택을 대체할수 있다.
// DFS에 추가되는 if는 아주 적은 시간을 소요한다고 생각하자
// 한개의 트리 마저도 왼쪽 값으로 오른쪽 트리의 값을 대체한다 !
