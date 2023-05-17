package nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body> {
    public int h, w;
    Body(int h, int w) {
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Body o){
        return o.h - this.h;  // 내림차순은 객체 - this
    }
}
public class Nine_one {
    public int solution(ArrayList<Body> arr, int n) {
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE; // 맨 처음 선수는 반드시 참이 된다.
        for(Body ob : arr) {
            if (max < ob.w) {
                cnt++;
                max = ob.w;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Nine_one T = new Nine_one();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            Body body = new Body(h,w);
        }
        System.out.println(T.solution(arr, n));
    }

}
// 모든 선수들의 키를 오름차순으로 정렬했기에 아래 있는 선수들은 윗 모든 선수들 보다 반드시 몸무개가 많이 나가야 한다,
// 따라서 max로 위 선수들중 몸무개 max를 갱신하며 그 선수보다 크면 참여가 가능하다고 생각하라 !
// 최적의 방법의 빠른 순이기에 이것도 그리디의 한 종류이다.
// 현재에서 최선의 선택의 방법을 선택하고 나중에 돌아봐도 잘했다면 이게 그리디 기법이다.
// 나중에 돌아보니 최선의 선택이 아니였다 -> 그리디 기법이 아니다 -> 이런건 다이나믹 동적 기법으로 풀어야 한다.
// 탐욕 알고리즘. 현재 상황에서 최소한의 가장 좋은 방법을 사용하는 것이다.
// 2중 for문 -> n^2 이다.
// 6장에 좌표정렬 복습 요망
