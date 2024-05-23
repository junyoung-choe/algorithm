import java.util.*;
class Solution {
    static ArrayList<Long> number = new ArrayList<>();
    static ArrayList<Character> sign  = new ArrayList<>();
    static long answer = 0;
    static char[][] arr = {{'+','-','*'} , {'+','*','-'} , {'-','+','*'} , {'-','*','+'} , {'*','+','-'} , {'*','-','+'}};
    public long solution(String expression) {
        
        // init
        String num = "";
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i);
            } else {
                number.add(Long.parseLong(num));
                num = "";
                sign.add(expression.charAt(i));
            }
        }
        // 이게 없어서 틀렸었다.
        number.add(Long.parseLong(num));
        
        // 재귀의 순열대신 for 문 
        for(char[] cl: arr) {
            answer = Math.max(make(cl), answer);
        }
        
        return answer;
    }
    
    public static long make(char[] cl) {
        ArrayList<Long> N = new ArrayList<>(number);
        ArrayList<Character> S  = new ArrayList<>(sign);
        
        // 기호 갯수
        for(int i=0; i<3; i++) {
            // 부호를 기준으로 살핀다
            for(int j=0; j<S.size(); j++) {
                if(cl[i] == S.get(j)) {
                    long tmp = cal(N.remove(j), N.remove(j), S.get(j));
                    N.add(j, tmp);
                    S.remove(j);
                    
                    // 이게 없어서 오류 났었다.
                    j--;
                }
            }
        }
        return Math.abs(N.get(0));
    }
    
    public static long cal(long a, long b, char c) {
        long result = a + b;
        switch(c) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            default :
                break;
        }
        return result;
    }
}

// 이러한 방법으로 깊은 복사가 되는 것을 확인할 수 있다.
// ArrayList<Long> N = new ArrayList<>(number);
// ArrayList<Character> S  = new ArrayList<>(sign);

// 컬렉션을 get 한뒤 추후에 바꾸는게 아니고 지우고 다시 넣어야 한다 ! 
// N.get(j) = cal(N.get(j),N.get(j+1),S.get(j));

// ArrayList remove 시 해당 인덱스 숫자를 반환한다 ! 
// N.remove(j)

// ArrayList remove 활용시 현재 인덱스를 -- 해주는걸 넣어야 한다.