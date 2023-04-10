package one;
import java.util.Scanner;
public class One_six {
    public String solution(String str){
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i) + " " + i + "" + str.indexOf(str.charAt(i)));
            if (str.indexOf(str.charAt(i)) == i)
                answer += str.charAt(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        One_six T = new One_six();
        System.out.println(T.solution(str));
    }
}

// System.out.println(str.charAt(i) + " " + i + "" + str.indexOf(str.charAt(i)));
//            if (str.indexOf(str.charAt(i)) == i)
//                answer += str.charAt(i);
// str.indexOf(문자) 문자열중에 해당 문자의 가장 앞의 인덱스를 가져온다.
// 즉 뒤에서 문자가 중복된다면 실제 인덱스 자리가 아니고 앞에 같은 문자가 존재하는 인덱스를 가져온다.
// 인덱스자리와 실제 자리가 같은 문자만 가져온다면 중복을 제거할수 있다.