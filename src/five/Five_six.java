package five;
import java.util.*;
public class Five_six { // 큐를 이용한다.
    public int solution(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            stack.push(i);      // 1 ~ 8 들어갔어 스택에
        }
        int cnt = 0;
        while(stack.size() != 1) {
            for (int i = 0; i < k; i++) {
                cnt++;
                if (cnt > stack.size()) cnt = 1;
            }
            stack.remove(cnt-1);
            cnt--; // 공주 구했다 한시간만에
        }
        return stack.pop();
    }
    public int solution1(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();     // queue는 이렇게 선언한다 !
        for (int i = 1; i <= n; i++) queue.offer(i);
        while (!queue.isEmpty()) {  //stack.size() != 0 이거랑 같은 뜻이다.
            for (int i = 1; i < k; i++)
                queue.offer(queue.poll()); // poll 제일 먼저 들어간 값을 꺼내면서 리턴 받은후 제일 뒤에 넣는다.  빠지지 않는 애들
            queue.poll();      // k를 외친 왕자이다.
            if(queue.size() == 1) answer = queue.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Five_six T = new Five_six();
        System.out.println(T.solution(n,k));
    }
}
// Queue를 이용한다. First in First out
// 값을 넣을때는 offer, 값을 뺄때는 poll 을 이용한다.
// peek() 맨 처음에 들어온 값을 확인한다.
// contain() 값이 있냐 없냐를 확인한다.
// isEmpty() 는 큐에 값이 없으면 1을 리턴한다.
