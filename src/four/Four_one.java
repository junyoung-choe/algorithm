package four;
import java.util.*;
public class Four_one {
    public char solution(int n, String str) {
        char answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // hashMap.put('A', 3);    //해쉬맵에 값을 넣는다. 한개의 세로가 쭉 추가된다.
        for (char key : str.toCharArray()) {
            hashMap.put( key, hashMap.getOrDefault(key, 0)+1 );  // 그냥 .get은 키가 존재하지 않으면 오류가 나오기에 .getOrDefault을 사용한다. (x, 0) x이라는 키가 없다면 0을 리턴하라
        }

        System.out.println(hashMap.containsKey('A')); // containsKey(key) key라는 값이 존재하냐? -> ture or false 리턴
        System.out.println(hashMap.size()); // size() -> 키의 갯수가 몇개이냐 !
        System.out.println(hashMap.remove('A')); // -> remove() 키의 값으로 맵 하나를 삭제한다.
        System.out.println(hashMap.size());         // 제거한후 갯수를 리턴.


        int max = Integer.MIN_VALUE;
        for (char key : hashMap.keySet()) {    // .keySet() 해쉬맵에 존재하는 모든 키 값을 리턴해준다.
            System.out.println(key + " " + hashMap.get(key));
            if(hashMap.get(key) > max){
                max = hashMap.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        scanner.close();

        Four_one T = new Four_one();
        System.out.println(T.solution(n, str));
    }
}

// hashmap   두가지 타입을 동시에 가지고 있다. key, value 형태
// .put(key, value) 맵에 값을 추가한다.
// .get(key)  -> 키 값으로 value를 가져온다.
//        hashMap.getOrDefault(key, 0)+1 );  // 그냥 .get은 키가 존재하지 않으면 오류가 나오기에 .getOrDefault을 사용한다. (x, 0) x이라는 키가 없다면 0을 리턴하라
//        System.out.println(hashMap.containsKey('A')); // containsKey(key) key라는 값이 존재하냐? -> ture or false 리턴
//        System.out.println(hashMap.size()); // size() -> 키의 갯수가 몇개이냐 !
//        System.out.println(hashMap.remove('A')); // -> remove() 키의 값으로 맵 하나를 삭제한다.
//        System.out.println(hashMap.size());         // 제거한후 갯수를 리턴.