package five;
import java.util.*;

class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;            // 처음 대기 목록상의 인덱스 번호를 가지고 있다.
        this.priority = priority;
    }
}
public class Five_eight {
    public int solution(int n, int m, int[] arr) {
        //PriorityQueue<Integer> queue = new PriorityQueue<>(); // 오름차순 큐
        //PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순으로 큐를 선언한다.
        Queue<Person> queue = new LinkedList<>();
        int answer = 1;
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        while(!queue.isEmpty()){
            Person tmp = queue.poll();     // 제일 앞의 객체 하나를 꺼낸다.
            for (Person x : queue) {       // 객체를 순서대로 보기만 한다. (꺼내는것은 아니다)
                if (tmp.priority < x.priority)
                    queue.offer(tmp);       // 맨 앞의 객체의 우선순위보다 높은게 있으면 다시 뒤로 넣는다.
                    tmp = null;
                    break;                  // 자기보다 우선순위 높은 환자를 확인했으니 뒤로 보내고 끝낸다.
            }
            answer++;
            if (tmp.id == m) return answer;
        }
        return answer; // 에러가 안나게 하려고 만듬.
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        scanner.close();

        Five_eight T = new Five_eight();
        System.out.println(T.solution(n,m,arr));
    }
}
