package one;
import java.util.Scanner;
public class One_five {
    public String solution(String str) {
        char c[] = str.toCharArray();   // toCharArray -> 문자배열이 생성된다..
        int lt = 0, rt = c.length-1;   // left right
        while (lt < rt){  // 모든 조건은 false 일때 그만둔다.
            if (!Character.isAlphabetic(c[lt])) lt++;  // 문자가 특수문자라면 1을 리턴한다.
            else if (!Character.isAlphabetic(c[rt])) rt--;
            else {
                char tmp;
                tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++; rt--;
            }
        }
        String result = String.valueOf(c); // c라는 배열을 String 화 시킨다. c가 정수여도 문자여도 가능하다,
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        One_five T = new One_five();
        System.out.println(T.solution(str));

    }
}
// Character.isAlphabetic(c[lt]) isAlphabetic 문자 문자가 알파벳이라면 참 1을 리턴한다.