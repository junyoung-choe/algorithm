package one;
import java.util.Scanner;
public class one_three {

    public String solution(String str) {
        String ts[] = str.split(" "); // 공백기준으로 자른 문자들의 배열을 제작한다.
        String result = ""; // 초기화 해줘야한다.

        for (int i = 0; i < ts.length; i++) {
            if (result.length() < ts[i].length()) result = ts[i];
        }
        return result;
    }

    public String solution2(String str) { //str.split 사용
        String answer = ""; // 최기화 시킨다
        int m = Integer.MIN_VALUE; // -0.134... 이라는 일정 값으로 초기화 시킨다.
        String ts[] = str.split(" ");

        for (String x : ts) {
            int length = x.length(); // 문자열의 길이를 리터한다.
            if (length > m) { m = length; answer = x;}
        }
        return answer;
    }

    public String solution3(String str) { // str.indexOf , str.substring 사용
        String answer = "";
        int m = Integer.MIN_VALUE, pos; // = int pos
        while((pos = str.indexOf(" ")) != -1) { // 띄어쓰기를 발견 못하면 -1 이다 | 발견하면 인덱스 번호를 리턴한다. 결국 괄호 뒤에가 != 에 적용된다.
            String tmp = str.substring(0, pos); // 0 부터 pos(인덱스로 공백자리) 앞까지 자른다. 그후에 대입한다.
            if (tmp.length() > m) { m = tmp.length(); answer = tmp;} // 계속해서 갱신한다.
            str = str.substring(pos+1); // str에는 자른자리 공백뒤 문자만 남도록 변경된다.
        }
        if(str.length() > m) answer = str; // 마지막 단어 뒤어는 공백이 존재하지 않기에 남은 단어로 비교해줘야 한다.
        return answer;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        one_three t = new one_three();
        System.out.println(t.solution(str));
    }
}
// 한줄을 입력받을때 nextLine()
// string 공백 넣을때 " "   초기화는 ""
// int i = 0 대신 int i = Integer.MIN_VALUE
// String str[] = sentence.split(" ") 공백 기준으로 자르면서 배열에 입력된다.
// str배열 크기만큼 for 문 돌리려면 |1. String x : str |2. str.length
// 문자열의 길이는 length(), 문자열의 배열은 length
// int i = str.indexOf(" ") 공백의 인덱스 자리를 리턴한다. (int i = str.indexOf(" "))
// (int i = str.indexOf(" ")) 인덱스의 자리를 리턴하며 자리가 있을때 띄어쓰기를 발견하지 못하면 -1 을 리턴한다.
// str = str.substring(0, pos); 0부터 pos의 인덱스 앞까지 자른다.
// str = str.substring(pos + 1); pos + 1 인덱스부터 끝까지 남긴다.