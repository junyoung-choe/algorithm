package four;

import java.util.*;

public class Four_two {
    public String solution(String str1, String str2) {
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();


        for (char key : str1.toCharArray()) {
            hashMap1.put(key, hashMap1.getOrDefault(key, 0) + 1);
        }
        for (char key : str2.toCharArray()) {
            hashMap2.put(key, hashMap2.getOrDefault(key, 0) + 1);
        }

        for (char key : hashMap1.keySet()) {
            if (hashMap1.get(key) != hashMap2.get(key)) return "NO";
        }

        return "YES";
    }

    public String solution2(String str1, String str2) { // 한개의 해쉬를 가지고 구한다.
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0)
                return "NO";      // 해당 키값이 존재하지 않거나, 키값의 values 가 0이라면 조건에 만족하지 않는다.
            map.put(x, map.get(x) - 1);                                 // 값이 존재하고 values 도 0이 아니라는 뜻이다.
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        scanner.close();

        Four_two T = new Four_two();
        System.out.println(T.solution(str1, str2));
    }
}
