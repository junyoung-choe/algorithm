package nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class wedding implements Comparable<wedding> {
    int start, finish;
    public wedding(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(wedding o) {
        if (this.finish == o.finish) // 끝나는 시간이 먼저 오름차순으로 정렬하며 같은 경우만 시작시간 오름차순 정렬
            return this.start - o.start ; // 오름차순으로 정렬한다.
        else
            return this.finish - o.finish ; // 오름차순으로 정렬한다. -> 오름차순 앞에 this
    }
}
public class Nine_three {

    public int solution(ArrayList<wedding> arr) {
        Collections.sort(arr); // 종료 시간을 오름차순으로 정렬 | 같은 상황이라면 실행 시간을 오름차순으로 정렬
        int answer = 0;
        for (int i = 0; i < arr.size() -1 ; i++) {
            int people = 1; // 현재 i 번째 인덱스의 사람 1
            wedding w = arr.get(i);
            for (int j = i+1; j < arr.size() -1; j++) {
                wedding tmp = arr.get(j);
                if(tmp.start > w.start && tmp.start < w.finish) people++;
            }
            answer = Math.max(answer, people);
        }
        return answer;
    }

    public static void main(String[] args) {
        Nine_three T = new Nine_three();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<wedding> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int finish = scanner.nextInt();
            arr.add(new wedding(start, finish));
        }
        System.out.println(T.solution(arr));
    }
}
