package one;
import java.util.Scanner;

public class One_twelve {
    public String solution(String str, int size) {
        str += " "; // 서브 스트링 자르는 뒷 부분은 +1 해서 적기 때문에.
        String answer = ""; // 문자 들어가는 곳 (결과)
        for (int i = 0; i < size; i++) {
            String two = "";  // 0 or 1
            String code = ""; // # or *
            code = str.substring(i*7, ((i+1)*7)+1);        // 7개의 (문자)2진수로 만든다.
            for (int j = 0; j < 7; j++) {
                if (code.charAt(j) == '#') two += 1;
                else two += 0;                             // 7개의 (숫자)2진수로 만든다.
            }
            int ten = Integer.parseInt(two, 2);      // 2진수를 10진수로 변환한다.
            answer += (char)ten;

        }
        return answer;
    }
    public String solution2(String str, int size) {
        String answer = "";
        for (int i = 0; i < size; i++) {      // 0~6 인덱스로 자르고 # -> 1 | * -> 0 으로 변경한다.
            String tmp = str.substring(0,7).replace('#','1').replace('*','0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            str = str.substring(7); // 인덱스 7부터 끝까지 자른다.
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String str = scanner.next();
        scanner.close();

        One_twelve T = new One_twelve();
        System.out.println(T.solution(str, size));
    }
}

// for 에서 i+1 다루는것은 범위나 문자에 공백 추가하는거 고려하기 !
//int ten = Integer.parseInt(two, 2);      // 2진수를 10진수로 변환한다.
//            answer += (char)ten;         // 10 진수를 아스키 코드에 따라서 문자로 변환하기 !

// String tmp = str.substring(0,7).replace('#','1').replace('*','0');
// String tmp = str.substring(0,7)    // 자르고
// str = str.substring(7);            // 자른부분 사용하고 지우기 !