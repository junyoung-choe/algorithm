package one;
import java.util.Scanner;
public class One_nine {
    public String solution(String str){ // 준영
        str = str.toLowerCase().replaceAll("[^0-9]","");
        return str;
    }

    public int solution1(String str){ // 문자 "0" -> 48  문자 "9" -> 57 (아스키 코드로)
        int answer=0;
        for(char x : str.toCharArray()){
            if (x>=48 && x<=57) answer=answer*10+(x-48); // 문자로 된 숫자를 변경
        }
        return answer;
    }

    public int solution2(String str){
        String answer="";
        for(char x : str.toCharArray()){
            if (Character.isDigit(x)) answer += x; //isDigit는 숫자일때 1로 리턴한다 즉 참 !
        }
        return Integer.parseInt(answer);  //Integer.parseInt(answer) String 값이 자연수로 바꿔준다(int형으로)
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        One_nine T = new One_nine();
        System.out.println(T.solution(str));
    }

}
// if (x>=48 && x<=57) answer=answer*10+(x-48); 문자열로 맨앞 0을 제외한 숫자를 이어 붙이는 방법
// Character.isDigit(문자) 숫자인 문자이면 1을 리턴한다.
// Integer.parseInt(문자열) 문자열을 숫자로 바꿔준다 (int 형으로)