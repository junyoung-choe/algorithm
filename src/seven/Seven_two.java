package seven;

import java.util.ArrayList;

public class Seven_two {
    //ArrayList<Integer> arrayList = new ArrayList<>();  // 재귀 안에서 한가지 객체 쓰고 싶으면 전역으로 선언 !
    public void DFS(int n) {
        if (n == 0) return;
        else {
            DFS(n / 2);         // 안에 얼마나 들어갔다가 나오든 한 메소드 안에서의 지역변수는 변하지 않는다.
            //arrayList.add(n%2);
            System.out.print(n % 2 + " ");
        }
    }
    public static void main(String[] args) {
        Seven_two T = new Seven_two();
        T.DFS(11);
    }
}
