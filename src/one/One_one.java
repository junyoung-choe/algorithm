package one;
import java.util.Scanner;
public class One_one {
    public int solution(String sentence, char checker ) {
        sentence = sentence.toUpperCase();   // 소문자로 전부 변경하기
        checker = Character.toUpperCase(checker); // 한개의 문자를 변경시에는 Character 클래스를 사용한다.
        //sentence = sentence.toUpperCase();   // 대문자로 전부 변경하기
        int count = 0;
        /*
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == checker) count++;
        }
        */
        // 스트링 뒤에 toCharArray()는 문자열을 문자 배열로 변환시킨다. 이때 sentence가 바뀌는것은 아니다.
        for (char x : sentence.toCharArray()) { // 향상된 for문으로 :앞에 변수에 :뒤에 크기만큼 대입한다 | : 뒤에는 배열이나 컬렉션만 올수 있다.
            if (x == checker) count++;
        }
            return count;
    }
    public static void main(String[] args) {
        One_one o = new One_one();

        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.next();
        char checker = scanner.next().charAt(0); // 문자를 입력받는 방법
        scanner.close();

        System.out.println(o.solution(sentence, checker));
    }
}
//Character.toUpperCase(문자) 문자를 대문자로 변경
//str.toUpperCase() 해당 문자열을 전부 대문자로 변경 | str이 바뀌는것은 아니다
// char c = scanner.next().charAt(0) 문자를 입력받는 방법
// 향상된 for문 변수 : 배열이나, 컬렉션만 가능하구 size나 length 만큼 진행한다.