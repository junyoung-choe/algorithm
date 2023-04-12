package one;
import java.util.Scanner;
public class One_eleven {
    public String solution(String str) {
        String answer = "";
        str += " ";                   //마지막 문자와 그 다음 문자를 비교하는 for 알고리즘을 작성했으니 빈공간 하나 만들기 !
        int times = 1;                // 왜 0이 아니고 1인지 생각해보기
        char c[] = str.toCharArray();
        for (int i = 0; i < str.length()-1; i++) { // 문장에 i 와 i+1 이 존재하니 길이에서 - 1 만큼만 진행
            if (c[i] == c[i+1]) times++;
            else {
                answer += c[i];
                if(times > 1) answer += String.valueOf(times); //int형 times을 string으로 변경한다.
                /*     //이거 보다 위에가 효율이 좋다.
                if(times == 1) answer += c[i];
                else answer = answer + c[i] + times;
                */
                times = 1;
            }
        }
        //if (!(c[str.length()-2] == c[str.length()-1])) answer += c[str.length()];
        //str에 공백 문자를 하나 추가함으로써 이게 필요가 없다.
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        One_eleven T = new One_eleven();
        System.out.println(T.solution(str));
    }
}

// String.valueOf(times); //int형 times을 string으로 변경한다.
// 문자열 내의 다음 문자와 비교하려고 할때는 -> 문자열에 공백 하나를 추가해준다.
// for (:) 쓸때 char []c = str.toCharArray 쓰고
// 인덱스가 필요시에는 fori로 가고 str.charAt() 쓰자 !!