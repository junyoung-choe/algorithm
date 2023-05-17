package seven;

public class Seven_four {
    public int DFS(int n) {
        if(n==1) return 1;
        if(n==2) return 1;
        else return DFS(n-1) + DFS(n-2); // 여기에서는 트리가 생성되기에 출력 구현이 어렵다
    }

    public static void main(String[] args) {
        Seven_four T = new Seven_four();
        //System.out.println(T.DFS(10));
        for (int i = 1; i <= 10; i++) {
            System.out.print(T.DFS(i) + " "); // 여기서 출력을 구현해줘야 한다.
        }

    }
}

// 피보나치 수열
// 배열이나 for 문도 가능하지만
// 재귀도 연습해보기 좋다 -> 어떤게 성능이 더 좋냐? -> 당연히 for나 배열이 좋다.
// 재귀함수는 스택의 프레임워크를 사용하기에 성능이 좋지는 않다. 메모리 낭비도 많다.
// 스택 프레임(한개의 스택을 지칭)  스택에 복귀주소, 메모리, 지역변수 수많은 정보가 스택에 계속해서 쌓인다 (트리도 생긴다)
// for문은 main 메소드의 한개의 스택만 생성된다.
// 우선 DFS(n)의 최종 값을 구한다는 생각으로 접근하면 좋다.
