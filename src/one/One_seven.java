package one;
import java.util.Scanner;
public class One_seven {
    public boolean solution(String str){
        str = str.toLowerCase();
        char c[] = str.toCharArray();
        int lt = 0, rt = c.length -1;
        while (lt < rt){
            if (c[lt] != c[rt]) return false;
            lt++; rt--;
        }
        /*   같은 방법이다.
        for (int i = 0; i < str.length()/2 ; i++) { // 문자의 갯수가 홀수일시 잘려도 어차피 중간 값은 같은것이다.
            if (str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
         */
        return true;
    }
    public boolean solution1(String str) {
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(tmp)) return true; // str.equalIgnoreCase() 동하여 대소문자 관계없이 비교한다.
        else return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        One_seven T = new One_seven();
        if (T.solution(str) == true) System.out.println("YES");
        else System.out.println("No");
    }
}

//str.equalIgnoreCase() 동하여 대소문자 관계없이 비교한다.
//String tmp = new StringBuilder(str).reverse().toString(); 문자열을 거꾸로 뒤집는 명령어
//for (int i = 0; i < str.length()/2 ; i++) { // 문자의 갯수가 홀수일시 잘려도 어차피 중간 값은 같은것이다.
//        if (str.charAt(i) != str.charAt(str.length()-1-i)) return false;
// -> lt, rt 와 비슷한 알고리즘이다,