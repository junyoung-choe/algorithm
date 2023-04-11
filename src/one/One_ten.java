package one;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class One_ten {
    public String solution(String str, char t){
        int size = str.length();
        int p = 0;
        char c[] = str.toCharArray();
        int answer[] = new int[size];
        for (int i = 0; i < size; i++) {
            if(c[i] == t) p = 0;
            else p++;
            answer[i] = p;
        }
        p = 0;
        for (int i = size - 1; i >= 0; i--) {
            if(c[i] == t) p = 0;
            else p++;
            if(answer[i] > p) answer[i] = p;
        }
        return Arrays.toString(answer);   // answer.toString() 이 아니라 | Arrays.toString(answer)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char t = scanner.next().charAt(0);
        scanner.close();

        One_ten T = new One_ten();
        System.out.println(T.solution(str,t));
    }
}
// 거리를 가지는 p 라는 int형 변수를 생성하고 거리를 나타내는 int형 배열에 p값을 넣어준다.
// 0~size까지 한번 size~0까지 한번씩 돌리면서 최소거리를 알아낸다. (알고리즘)