package five;
import java.util.*;
public class Five_two {
    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char c : str.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') stack.pop();
            else {
                if (stack.isEmpty()) answer += c;
            }
        }
        return answer;
    }

    public String solution2(String str) { // only 스택만 사용한다.
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char c : str.toCharArray()) {
            if(c == ')'){
                while(stack.pop() != '(' ); // pop은 꺼내기도 하지만 꺼낸 값도 리턴받는다. while문을 이렇게도 사용한다 !
                //System.out.println(stack.pop()); // 값을 꺼냄과 동시에 값을 리턴받아서 출력한다.
            }
            else stack.push(c); // 여는 괄호와 알파벳은 다 푸쉬해준다.
        }
        for (int i = 0; i < stack.size(); i++) {   // for each로도 사용이 가능하다.
            answer += stack.get(i); // 0은 가장 아래의 스택을 의미한다. 이거는 값을 빼는게 아닌 리턴만 받기에 가능하다
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Five_two T = new Five_two();
        System.out.println(T.solution(str));
    }
}

//stack.get(i) 으로 가져올수 있고
//for (char x : stack) 으로도 가져올수 있다.
//stack.pop() 최상단 값을 제거하면서 값도 가져온다.