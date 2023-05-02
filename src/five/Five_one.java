package five;

import java.util.Scanner;
import java.util.Stack;

public class Five_one {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for( char x : str.toCharArray()){
            if(x =='(') stack.push(x);
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();  // 제일 상단에 있는것을 하나 꺼낸다.
            }
        }
        if(!stack.isEmpty()) return "NO";    //스택의 자료가 남아있다면 ( 이게 더 많다면.
        return answer;                       //-> return "NO" 2개여도 괜찮다.
    }

    public static void main(String[] args) {
        Five_one T = new Five_one();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }

}


// 여는괄호 스택에 넣고 닫는 괄호 만나면 스택에서 여는 괄호를 하나씩 뺀다.
// stack 문제의 가장 기본이다. Last In First Out , 문제에 괄호가 있다면 stack을 보통 많이 사용한다.
// 운동장에 웅덩이에 공이 빠진다고 생각 1, 2, 3 공이 빠졌다고 생각 들어가는 곳이나 나오는 곳이 똑같기 때문에
// stack 값 넣을때 push, 값 뺄때는 pop , isEmpty() -> 스택이 비어있냐?
// queue 입구 출구가 따로있다. First In First Out