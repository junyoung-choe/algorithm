package five;

import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.util.Stack;

public class Five_five {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){    // for each 안하고 인덱스로 접근하는 이유는 -> 인덱스 번호를 계속해서 사용해야 하기 때문이다.
            if (str.charAt(i)=='(') stack.push('(');
            else {
                stack.pop(); // 즉 ) 이 들어왔다는 이야기이다. 막대기든 레이저든 빼준다.
                if(str.charAt(i-1) == '(') answer+=stack.size(); // 스택을 들여다 보는게 아니라 문자열을 들여다 본다.
                else answer++;  // 이 경우는 레이저가 닫는 괄호가 아닌 파이프를 자르는 괄호이다. 파이프를 마감하니 +1 만
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Five_five T = new Five_five();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(T.solution(str));
    }
}
// ) 이게 막대기의 끝인지 레이저의 끝인지 알아야한다.
// 닫는 괄호를 만났을때 바로 앞이 ( 인지 ) 인지를 확인하여 알수있다.
// ( 가 스택에 계속해서 쌓이다가 )를 만나서 레이저로 판명되면 앞에의 ( 의 갯수는 즉 막대기이다.
// ( 의 갯수만큼의 막대기를 자른다

