import java.io.*;
import java.util.*;
// 알파벳을 정렬해서 입력해주기 때문에 
// 순서대로 즉 인접한 코스 요리만 생각하면 된다 ! 
// HASH 맵을 사용해서 하면 어떨까 ! 

// <String, Integer> 로 저장해서 getOrDefault 를사용해서 Integer에 cnt를 담고
// cnt 가 2 이상인 메뉴들을 정답으로 만든다 ! 
// 이후 알파벳 순서대로 오름차순으로 정렬한다.

// 해시맵을 다루는 방법
// https://developer-talk.tistory.com/392#google_vignette
// https://kutar37.tistory.com/entry/%EC%9E%90%EB%B0%94-String%EC%9D%84-Char%EB%A1%9C-Char%EB%A5%BC-String%EC%9C%BC%EB%A1%9C-%EB%B3%80%ED%99%98%ED%95%98%EA%B8%B0
// String.valueOf(ch) | Arrays.toString(ch)
class Solution {
    static ArrayList<String> answer;
    static char[] sel;
    static int[] max_refered;
    static Map<String, Integer> map;
    public ArrayList<String> solution(String[] orders, int[] course) {
        map = new HashMap<>();
        
        // 가장 큰 길이로 sel 배열과 가장 큰 길이를 저장하는 배열을 만들어둔다 
        int long_length = 0;
        for(int tmp : course) {
            long_length = Math.max(long_length, tmp);
        }
        sel = new char[long_length];
        max_refered = new int[long_length+1];
        
        // 알파벳 순서대로 정렬 
        for(int i=0; i<orders.length; i++) {
            char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            orders[i] = String.valueOf(ch);
        }
        
        // 조합 만들기
        for(String order : orders) {
            for(int cnt : course) {
                combination(0, 0, order, cnt);    
            }
        }
        
        
//         // 각 주문리스트를 확인한다
//         for(int i=0; i<orders.length; i++) {
//             // 가능한 코스 길이들을 확인한다.
//             String now_order = orders[i];
//             int now_order_len = orders[i].length();
            
//             // 현재 찾고자 하는 코스의 길이를 확인한다.
//             for(int j=0; j<course.length; j++) {
//                 int now_course_len = course[j];
                
//                 // 주문 리스트에서 코스의 조합을 만들어본다 
//                 for(int l=0; l<now_order_len-now_course_len; l++) {
//                     String str = now_order.substring(l, l+now_course_len+1);
//                     int tmp = map.getOrDefault(str, 0) + 1;
//                     map.put(str, tmp);
//                 }
//             }
//         }
        
        answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            // 2번 이상 나오지 않았다면 넘긴다 
            if(entry.getValue() == 1) continue;
            
            if(max_refered[entry.getKey().length()] != entry.getValue()) continue;
            
            answer.add(entry.getKey());
            
            // 원래 메뉴 조합이 있는지 확인한다 ! 
            // for(String str : orders) {
            //     if(entry.getKey().equals(str)) {
            //         answer.add(str);
            //         break;
            //     }
            // }
        }
        Collections.sort(answer);
        return answer;
    }
    
    public static void combination(int idx, int k, String order, int cnt) {
        if(idx == cnt) {
            String str = "";
            for(int i=0; i<cnt; i++) {
                str += sel[i];
            }
            int tmp = map.getOrDefault(str, 0) + 1;
            map.put(str, tmp);
            max_refered[cnt] = Math.max(max_refered[cnt], tmp);
            return;
        }
        
        for(int i=k; i<order.length(); i++) {
            sel[idx] = order.charAt(i);
            combination(idx+1, i+1, order, cnt);
        }
    }
}

// 원래 있던 메뉴 리스트만 정답 후보가 될수 있다는 점을 놓쳤구
// 알고 나서도 어떻게 해결해야 할까 고민이 됬다 ! 
// 이는 원래 메뉴 리스트중에서 해당하는지 매칭해서 해결이 가능했다 

// 하지만 문제에서 요구함은 이게 아니였다 
// 각 course 길이중에 가장 많이 참조된 것들이 정답이 된다 ! 
// 문제를 잘 이해하고 푸는것이 너어무 중요하다 !