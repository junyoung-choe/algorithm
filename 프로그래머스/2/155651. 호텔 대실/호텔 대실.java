import java.util.*;
class Solution {
    static class Time implements Comparable<Time> {
        int type;
        int times;
        public Time(int type, int times) {
            this.type = type;
            this.times = times;
        }
        @Override
        public int compareTo(Time o) {
            if(this.times == o.times) return o.type - this.type;
            return this.times - o.times;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        
        ArrayList<Time> arr = new ArrayList<Time>();
        for(int i=0; i<book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":",""));
            int end = Integer.parseInt(book_time[i][1].replace(":","")) + 10;
            
            // 60분 넘은 처리 
            int con = end % 100;
            if(con > 60) {
                // 틀렸던 부분
                //end += 100 + (con - 60);
                end += 40;
            }
            
            arr.add(new Time(0, start));
            arr.add(new Time(1, end));
            // System.out.println(start + " " + end);
        }
        int room = 0;
        Collections.sort(arr);
        for(Time now : arr) {
            // System.out.println(now.times + " " + now.type);
            if(now.type == 0) {
                room++;
            } else {
                room--;
            }
            
            answer = Math.max(answer, room);
        }
        
        return answer;
    }
}

// 시간 변경하는 방법은 다음과 같다 ! 
// 틀렸던 부분
// end += 100 + (con - 60);
// 이게 아닌 
// end += 40; 이것이다