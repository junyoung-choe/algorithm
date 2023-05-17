package six;
import java.util.*;
public class Six_nine {
    public int solution(int n, int m, int[] arr) {  // 준영
        int answer = 0, length = n, pointer = 0;
        while (true) {
            length--;
            int max = 0;
            for (int i = n-1; i >= length ; i--) { // 제일 큰 메모리의 드라이브를 끝에서부터 한개씩 늘려나간다.
                max += arr[i];
                pointer = i-1;   // 밑에서 새로운 드라이브의 시작 인덱스
            }
            int sum = 0;
            for (int i = pointer; i >=0 ; i--) {
                if(sum > max) break;
                sum += arr[i];
                pointer = i-1;
            }
            sum = 0;
            for (int i = pointer; i >=0 ; i--) {
                sum += arr[i];
            }
            if (sum > max) continue;
            return max;

        }
    }
    public int solution1(int n, int m, int[] arr) {    // 선생님 방법
        int answer=0;                                  // stream을 사용해서 for문을 생략한다.
        int lt = Arrays.stream(arr).max().getAsInt(); // arr 의 배열중에 가장 큰수를 Int 형으로 리턴해준다
        int rt = Arrays.stream(arr).sum();            // sum() 함수는 기본형에 맞게 리턴해주므로 getAsInt() 필요가 없다.
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid) <= m) {    // mid 가 dvd 한장의 용량이다.
                answer = mid;
                rt = mid - 1;       //if 문이 만족한다면 최소 용량이니 오른쪽 값들은 다 버린다
            }
            else lt = mid+1;        // m 장으로 곡들이 담아지지 않는다면
        }
        return answer;
    }
    public int count(int[] arr, int capacity){ // count 는 사용하는 dvd 갯수이다 | 이게 m보다 작거나 같으면 가능하다는 뜻이다.
        int cnt=1, sum = 0;    // cnt는 dvd 갯수 적어도 한장은 사용한다. sum은 dvd에 담아지는 곡들의 합
        for(int x : arr) {
            if(sum + x > capacity){ // 용량이 넘어가면 이쪽으로 가서 sum 초기화와 dvd 갯수 증가시킨다. | 이렇게 제작하여야 마지막 dvd에 메모리를 초과하지 않아도 장수가 3으로 남는다.
                cnt++;
                sum = x;
            }
            else sum += x; // 여기로 계속 가다가.
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Six_nine T = new Six_nine();
        System.out.println(T.solution(n, m, arr));
    }

}
// 결정 알고리즘 -> 이분 탐색의 응용 -> 좁혀 나가면서 가능한거중.  최선의 답을 찾아가는 방법이다. -> 나중에도 가능한게 더 최선이다.
// lt와 rt 사이에 무조건 답이 있다는 확신이 있을때 결정 알고리즘을 사용할수 있다. ( 이분 탐색 )
// 답이 가능해? 이 상태에서 더 효율적인 방법 탐색까지 해야한다.
// 최소 메모리부터(제일 긴 한곡), 최대 메모리 (즉 모든 곡들의 합) 이거를 탐색한다고 생각하자 ! -> 이 중에 답이 무조건 있다는 확신이 있다.
// 9(lt) ~ 45(rt) mid -> 27((lt + rt) /2)
// 이분검색은 계속해서 간다면 lt가 rt 보다 크거나 같아진다.
// Arrays.stream(arr).max().getAsInt(); // arr 의 배열중에 가장 큰수를 Int 형으로 리턴해준다
// Stream에 대해서 이것이 자바다 (신형권) 책에 자세하게 있다.
//