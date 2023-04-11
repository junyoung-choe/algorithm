package one;
import java.util.Scanner;
public class One_eight {
    public String solution(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-z]", ""); // 띄어쓰기도 제거된다.
        // 모두 대문자로 변경후 .replaceAll() ()에 정규식 쓸수 있다. | (아니면) -> ^  A-Z 즉 A~Z 까지가 아니면~ "" 빈 문자화를 시켜버려라!!
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer = "YES";
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        One_eight T = new One_eight();
        System.out.println(T.solution(str));
    }
}

// str.replaceAll(조건, 변형) // 문자열중에서 일정 부분을 조건으로 제거하거나 변형할수 있다.
