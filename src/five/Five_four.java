package five;
import java.util.*;
public class Five_four {
    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c))
                stack.push(c-48);  // 숫자를 나타내는 문자의 아스키 코드에서 48을 뺀다면 문자에 해당하는 숫자가 된다,  char c = 8 은 숫자로 변경하려면 int i = c - 48
            else {
                int tmp;
                int rt = stack.pop();   // 먼저 나온 값이 연산자 뒤로 간다.
                int lt = stack.pop();
                if (c=='+') tmp = lt + rt;            // 연산자는 각 종류를 나눠서 이렇게 직접 구현해야 한다.
                else if (c == '-') tmp = lt - rt;
                else if (c == '*') tmp = lt * rt;
                else tmp = rt / lt;
                stack.push(tmp);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        Five_four T = new Five_four();
        System.out.println(T.solution(str));
    }

}


// 후위식이란 -> 5+3(중위식) -> 53+ 숫자는 가만히 있고 연산자만 뒤로간다.    -> 후위식을 연산시에는 (스택기준) 나중에 나온 값이 연산자 앞으로 간다.
// 352+*9- 이라면 -> 숫자는 스택에 쌓고 -> 연산자를 만났을때 최근의 2개의 숫자를 빼서 연산하고 결과를 스택에 넣는다.
// char c = 8 은 숫자로 변경하려면 int i = c - 48
