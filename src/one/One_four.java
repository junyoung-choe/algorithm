package one;
import java.util.ArrayList;
import java.util.Scanner;
public class One_four {
    // 선생님 방법 builder 사용 한꺼번에 바꾸기
    public ArrayList<String> solution(int times, String str[]) { // ArrayList<String> 리턴 타입일 뿐이다.
        ArrayList<String> answer = new ArrayList<>();  // 여기에 뒤집은 단어를 넣고
        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString(); //StringBuilder(x) x를 빌더 객체로 만든다
            //String 클래스도 문자열을 다루지만 StringBuilder 클래스도 문자열을 다룬다. toString 다시 문자열로 바꾼다.
            answer.add(tmp);
        }
        return answer;  // 뒤집은 단어 ArrayList를 보낸다.
    }

    public ArrayList<String> solution1(int times, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            char[] s = x.toCharArray(); // x의 문자열을 문자배열로 제작한다.
            int lt = 0, rt = x.length() - 1; //lt 는 처음에서 시작 rt 는 끝에서 시작
            while (lt < rt) { // 문자의 갯수가 짝수일때 홀수일때 둘다 작용한다.
                char tmp = s[lt];       // 이 알고리즘 중요하다 !
                s[lt] = s[rt];
                s[rt] = tmp;            // 두개를 교환시에 방법
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);  // 객체. 아니고 클래스.함수이기에 static으로 선언된 메소드이다. 다시 스트링으로 변경한다.
            answer.add(tmp);
        }
        return answer;
    }
    public void solution2(String str[]) { // 내생각
        String changer[] = new String[str.length];
        for (int i = 0; i < str.length; i++) changer[i] = "";
        for (int i = 0; i < str.length; i++) {
            for (int j = str[i].length() - 1; j >= 0; j--) {
                changer[i] += str[i].charAt(j);
            }
            System.out.println(changer[i]);
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        String str[] = new String[times];
        for (int i = 0; i < times; i++) {
            str[i] = scanner.next();
        }
        One_four T = new One_four();
        //T.solution2(str); //solution2 사용시
        for(String x : T.solution(times, str)) { // T.solution(times, str)는 ArrayList를 받는다. 즉 치환된다.
            System.out.println(x);
        }
    }
}

// ArrayList로 리턴타입 지정후 리턴을 ArrayList로 받아서 for : 사용해 알아서 배분된다. 기억하자
// String tmp = new StringBuilder(x).reverse().toString(); tmp에 x의 리버스가 들어간다. x는 String 변수이고 저렇게 사용한다. 마지막에 다시 문자열로 변환
// char[] s = x.toCharArray(); // x의 문자열을 문자배열로 제작한다.
// int lt = 0, rt = x.length() - 1; //lt 는 처음에서 시작 rt 는 끝에서 시작
//            while (lt < rt) { // 문자의 갯수가 짝수일때 홀수일때 둘다 작용한다. lt와 rt로 자리를 옮겨가는 알고리즘 중요하다 !!
//                char tmp = s[lt];
//                s[lt] = s[rt];
//                s[rt] = tmp;            // 두개를 교환시에 방법
//                lt++;
//                rt--;