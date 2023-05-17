package seven;

public class Seven_three {
    public int DFS(int n) {
        if (n == 1) return 1;
        else return n*DFS(n-1);   // 나머지가 값을 리턴해야 하니 n 값도 리턴하여 메인문에서 출력 !
    }
    public static void main(String[] args) {
        Seven_three T = new Seven_three();
        System.out.println(T.DFS(5));
    }
}
// 팩토리얼 5! -> 120
// 재귀함수의 리턴 타입이 void 이냐 변수형이냐에 따라서 조금 다르다는것을 기억하자