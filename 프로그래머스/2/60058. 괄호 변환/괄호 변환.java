// ( ) 갯수가 맞다면 1. 균형잡힌 괄호 문자열
// 짝도 맞다면      2. 올바른 괄호 문자열

// 입력이 빈 문자인 경우 빈 문자 반환 
// 이후 주어진 방법대로 재귀를 돌린다 ! 
// 해당 조건에서 ( 를 바로 붙여서 정리가 되는 이유는 ( 와 ) 의 갯수가 항상 같음을 보장하기 때문이다.
import java.util.*;

class Solution {
    static String answer = "";
    public String solution(String p) {
        answer = recursive(p);
        return answer;
    }
    
    public static String recursive(String str) {
        // 1
        if(str.equals("")) return "";
        
        // 2 균형잡힌 문자열을 찾는다 
        String result = "";
        int i = 0;
        int status = 0;
        for(; i<str.length(); i++) {
            if(str.charAt(i) == '(') status++;
            else status--;
            if(status == 0) break;
        }
        
        String u = str.substring(0, i+1);
        String v = str.substring(i+1, str.length());
        
        // 3
        if(check(u)) {
            result = u + recursive(v);
        } 
        // 4
        else {
            result = '(' + recursive(v) + ')';
            // result += u.substring(1,u.length()-1).replace('(',')').replace(')','(');
            for(int j=1; j<u.length()-1; j++) {
                if(u.charAt(j) == '(') result += ')';
                else result += '(';
            }
        }
        
        return result;
    }
    
    // 올바른 괄호 문자열인지 판단 !
    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.add('(');
            }
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        // 짝이 무조건 맞으니 굳이 남은 갯수 확인 x
        // return true;
        return stack.isEmpty();
    }
}

// result += u.substring(1,u.length()-1).replace('(',')').replace(')','(');
// 이게 되나?
// 안된다 !
// 만약 쓰려면 swap 처럼 다른 걸로 임시로 바꿔서 사용해야 한다 
// ex u = u.replace("(", ".") 이런식으로 바꾸고 마지막에 . 을 ) 로 바꿔야한다 ! 