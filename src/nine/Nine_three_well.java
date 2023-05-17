package nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time> {
    int time;
    char state;
    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time o) {
        if (this.time == o.time) // 끝나는 시간이 먼저 오름차순으로 정렬하며 같은 경우만 시작시간 오름차순 정렬
            return this.state - o.state ; // 알파벳으로 오름차순으로 정렬한다. (s , e)
        else
            return this.time - o.time ; // 오름차순으로 정렬한다. -> 오름차순 앞에 this
    }
}

public class Nine_three_well {

    public int solution(ArrayList<Time> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr); // 종료 시간을 오름차순으로 정렬 | 같은 상황이라면 실행 입장 퇴장을 오름차순으로 정렬 ( e -> s ) 알파벳순 e 가 먼저이다.
        int cnt = 0; // 현재 몇명이 존재하는지
        for (Time time : arr) {
            if (time.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt); // answer는 가장 큰수를 기록한다 ( 가장 사람이 많은 순간을 )
        }


        return answer;
    }

    public static void main(String[] args) {
        Nine_three_well T = new Nine_three_well();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Time> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = scanner.nextInt();
            int eT = scanner.nextInt();
            arr.add(new Time(sT, 's'));
            arr.add(new Time(eT, 'e'));
        }
        System.out.println(T.solution(arr));
    }
}

// 즉 s 는 계속해서 유입되는 사람이고
// 즉 e 는 계속해서 나가는 사람이다.
// 가장 많을때의 사람을 확인한다.
// 시간이 같을때 e를 먼저 넣은건 정각에는 이미 나갔다고 문제에서 가정했기 때문이다.
