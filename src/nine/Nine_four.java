package nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class lecture implements Comparable<lecture>{
    int money, day;
    public lecture(int money, int day) {
        this.money = money;
        this.day = day;
    }
    @Override
    public int compareTo(lecture o){
        return o.day - this.day; // 내림차순으로 정렬한다.
    }
}
public class Nine_four {
    static int n ,max_day = 0;

    public int solution(ArrayList<lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); // 정렬을 하면서 보관하는 Queue로 Collections.reverseOrder() 사용하면 내림차순으로 저장
        Collections.sort(arr); // arr 정렬
        int j=0;               // 왜 여기에다가 j를 선언하는지 생각해보기 !
        for (int i = max_day; i > 0 ; i--) {
            for (; j < n; j++) {
                if (arr.get(j).day < i) break;
                pQ.offer(arr.get(j).money); // 넣을때 자동 내림차순으로 들어간다.
            }
            if(!pQ.isEmpty()) answer += pQ.poll(); // i 날짜에 어떤 강의를 할것인지 선택한다. ( 오류를 예방하고자 큐가 비어있지 않다면 ! )
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();                // 강의의 갯수
        ArrayList<lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            int day = scanner.nextInt();
            max_day = Math.max(max_day, day); // 최대 일수를 구한다.
            arr.add(new lecture(money, day));
        }
        Nine_four T = new Nine_four();
        System.out.println(T.solution(arr));
    }

}
// 현재 사용할수 있는 값중에 가장 좋은 값을 선택한다 -> 그리디 기법
// 3일안에 할수있는것은 2일날도 할수 있기에 거꾸로 도는것이다.
// 일자로 정렬하여 ArrayList에 정렬하고 일자를 확인하며 큐에 내림차순으로 정렬하여 큰값을 꺼낸다.
// 어떤 단계에 값들을 빼서 그 값들만 비교하여 최대나 최소를 꺼낸다 -> 큐 사용
// 다음 단계에서 새로운 값들을 추가한다 !