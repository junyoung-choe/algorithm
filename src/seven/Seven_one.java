package seven;
import com.sun.tools.javac.Main;

import java.util.*;
public class Seven_one {
    public void DFS(int n) { // DFS는 깊이 우선 탐색의 약자이다.
        if (n == 0) return; // 아무것도 리턴하지 않는다. 즉 재귀함수의 끝을 정하는 것 void 형에선 그냥 return 을 써도 된다.
        else {
            System.out.println(n + " ");   //3,2,1 출력
            DFS(n - 1); //자기 자신을 호출한다.
            System.out.println(n + " ");   //1,2,3 출력
        }
    }
    public static void main(String[] args) {
        Seven_one T = new Seven_one();
        T.DFS(3);
    }
}
// 재귀함수 자기가 자기 자신을 호출하는 함수
// DFS(3) -> DFS(2) -> DFS(1) 각 각 호출한다.
// 재귀함수는 스택에 함수가 쌓인다 !!!!!
// DFS(3) 제일 밑에 깔린다. | 매개변수 정보, 지역변수 정보, 복귀주소를 각 스택에서 가지고 있다.
// DFS(2) 는 DFS(3)의 복귀주소를 가지고 있다. 다시 호출했던 함수를 돌아가는거 백트래킹 이라고 한다.
// 일반 메인 함수에서도 메소드 호출후 다음 메인 다음줄 돌아가듯이, 재귀함수도 스택에서 다시 빠져나오면 밑라인도 돌아야 한다,
// 각 자기 메소드가 끝나면 스택에서 pop 한다.