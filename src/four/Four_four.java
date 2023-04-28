package four;
import java.util.*;
public class Four_four {

    public int solution(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int answer = 0, lt = 0;
        int length_s = s.length(), length_t = t.length();
        char[] c_s = s.toCharArray(), c_t = t.toCharArray();
        for (int i = 0; i < length_t-1; i++) {
            hashMap.put(c_s[i], hashMap.getOrDefault(c_t[i], 0)+1);
        }      // 초기에 값을 해쉬에 대입한다.
        for (int rt = length_t-1; rt < length_s; rt++) {
            hashMap.put(c_s[rt], hashMap.getOrDefault(c_s[rt], 0)+1);
            if (hashMap.containsKey(c_t[0]) && hashMap.containsKey(c_t[1]) &&
                    hashMap.containsKey(c_t[2])) answer++;
            // 두개다 해쉬일경우에는 -> hashmap.equals(t로 만든 해쉬.) 같으면 ture 리턴
            hashMap.put(c_s[lt], hashMap.get(c_s[lt])-1);
            if(hashMap.get(c_s[lt]) == 0)
                hashMap.remove(c_s[lt]);
            lt++;
        }

        return answer;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        scanner.close();

        Four_four T = new Four_four();
        System.out.println(T.solution(s,t));

    }
}
// 자바는 두 해시맵을 비교하는 함수가 있기때문에 편리하다. 키와 밸류를 다 같이 봐준다.
// 그러니 t 문자열도 해시맵으로 만들어놓는게 효율이 좋다.