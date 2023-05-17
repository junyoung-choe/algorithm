package nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class meeting implements Comparable<meeting> {
    int start, finish;
    public meeting(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(meeting o) {
        if (this.finish == o.finish) // 끝나는 시간이 먼저 오름차순으로 정렬하며 같은 경우만 시작시간 오름차순 정렬
            return this.start - o.start ; // 오름차순으로 정렬한다.
        else
            return this.finish - o.finish ; // 오름차순으로 정렬한다. -> 오름차순 앞에 this
    }
}
public class Nine_two {
    public int solution(ArrayList<meeting> arrayList) {
        int answer = 0;
        int time = 0;
        for(meeting m : arrayList) {
            if (time <= m.start) {
                answer++;
                time = m.finish; // 조건이 만족할때만 끝나는 시간을 넣어야 한다.
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<meeting> arrayList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int finish = scanner.nextInt();
            arrayList.add(new meeting(start, finish));
        }
        Collections.sort(arrayList); // comparable 정의한대로 정렬한다.
        Nine_two T = new Nine_two();
        System.out.println(T.solution(arrayList));
    }
}
// 회의가 빨리 끝나는것을 먼저하는게 제일 많이 할수 있는 방법이다.
// 빨리 끝나는거 부터 계속해서 나간다 -> 그리디 기법
// 먼저 시작하는것을 선택하면 반례가 존재하기에 안된다.
// 시작 시간이 중복되는것도 생각해보기 !