package one;
import java.util.Scanner;
public class One_two {
    public String solution(String str){
        String str_changed = "";        // 이렇게 초기화 해놓구 str = str + c 하면은 끝에 문자가 추가된다 !!
        for (char c : str.toCharArray()){
            if (Character.isLowerCase(c)) c = Character.toUpperCase(c); // Character.isUpperCase(c) c가 대문자면 1리
            else c = Character.toLowerCase(c);
            str_changed += c ;        //
        }
        return str_changed;
    }

    public String solution2(String str){
        String str_changed = "";
        for (char c : str.toCharArray()){
            if (c >= 97 && c <= 122) c -= 32; // Character.isUpperCase(c) c가 대문자면 1리
            else c += 32;
            str_changed += c ;        // 65 ~ 90 대문자 97 ~ 122 소문자 32의 차이를 가지고 있다
        }
        return str_changed;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        One_two t = new One_two();
        System.out.println(t.solution2(str));
    }
}
// 문자열에 + 하는것 !!
// Character.isLowerCase(문자) 참 거짓 리법
// 대문자 65 ~ 90 | 97 ~ 122 소문자 각 문자의 대소는 32의 차이를 가지고 있다.
// char는 그냥 숫자로 비교가 가능하다 또한 범위를 &&로 다 써주는것이 좋다.
