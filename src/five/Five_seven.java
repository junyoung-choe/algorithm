package five;
import java.util.*;

public class Five_seven {
    public String solution(String imperative, String subject) {
        Queue<Character> queue = new LinkedList<>();
        for (char c: imperative.toCharArray())
            queue.offer(c);                     // 필수 과목을 큐에 저장한다.
        for (char c: subject.toCharArray()) {
//            if (queue.contains(c)){
//                if (c != queue.poll()) return "NO";
//            }
            if (queue.contains(c) && c == queue.peek())    // 필수과목이 큐에 존재하고, 해당 필수과목이 맨 앞에 있다면 (순서를 위해서)
                queue.poll();
        }
        if (queue.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String imperative = scanner.next();
        String subject = scanner.next();
        scanner.close();

        Five_seven T = new Five_seven();
        System.out.println(T.solution(imperative, subject));
    }
}

// 큐를 써야한다는 생각을 해야만한다.
// 보통 순서대로 일때 큐 많이 사용한다.