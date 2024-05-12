import java.util.*;
import java.io.*;

// info 배열의 크기는 1 ~ 50000
// query 배열의 크기는 1 ~ 100000
// 완탐을 한다면 50,0000,0000 50억으로 약 50초가 걸리는 상황이다 
// hash 맵을 사용해서 모두 조회가 가능하도록 만들어야 한다.
// + 이진탐색을 이용한 빠른 조회가 가능하도록 만든다 
// java backend junior pizza = - backend junior pizza 와 같다는걸 알고 넘어가야 한다
class Solution {
    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int info_cnt = info.length;
        int query_cnt = query.length;
        
        int[] answer = new int[query_cnt];
        
        String[][] make = { 
                {"", "-"},
                {"", "-"},
                {"", "-"},
                {"", "-"}
        };
        // 1. 해시맵 제작
        for(int i=0; i<info_cnt; i++) {
            String str[] = info[i].split(" ");
            for(int j=0; j<4; j++) {
                make[j][0]= str[j];
            }
            
            // 앞의 4개의 정보를 이은 문자로 key 값을 지정하고, value 로는 숫자를 넣어둔다
            for(int a=0; a<2; a++) {
                for(int b=0; b<2; b++) {
                    for(int c=0; c<2; c++) {
                        for(int d=0; d<2; d++) {
                            String tmp = "";
                            tmp += make[0][a];
                            tmp += make[1][b];
                            tmp += make[2][c];
                            tmp += make[3][d];
                            
                            ArrayList<Integer> arr = map.getOrDefault(tmp, new ArrayList<Integer>());
                            arr.add(Integer.parseInt(str[4]));
                            
                            // 빼먹은 부분 해시맵 꺼낸다음 다시 넣는다 (중복은 덮어 쓴다)
                            map.put(tmp , arr);
                        }
                    }
                }    
            }
        }
        // 2 해시맵 안의 arr들 정렬 ( 객체처럼 꺼내서 바꿔도 내부도 변경된다)
        // 해시맵 값들만 꺼내는 방법 ! 
        for(ArrayList<Integer> a : map.values()) {
            // a.sort(null);
            Collections.sort(a);
        }
        
        // 3. 질문 뜯어보기
        for(int i=0; i<query_cnt; i++) {
            String str[] = query[i].split(" and ");
            
            String tmp = str[0] + str[1] + str[2] + str[3].split(" ")[0];
            
            int number = Integer.parseInt(str[3].split(" ")[1]);
            
            // 오류 부분 꺼낼떄 Integer 타입이라고 명시를 해야한다 ! ! ! ! ! 
            // contain 빼먹었다
            if(map.containsKey(tmp)) {
                ArrayList<Integer> a = map.get(tmp);
            
                // 4. 이진탐색 (방법 잘 기억해 놓기 ! )
                int lt = 0;
                int rt = a.size();
                int mid = 0;
                while(lt < rt) {
                    mid = (lt + rt) / 2;
                    
                    // if(a.get(mid) == number) break;
                    if(a.get(mid) >= number) rt = mid;
                    else lt = mid+1;
                }
                
                answer[i] = a.size() - lt;
            }
            

        }
        return answer;
    }
}