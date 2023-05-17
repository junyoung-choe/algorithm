package ten;
import java.util.*;

class Brick implements Comparable<Brick>{  // 중요
    int s, h, w; // 밑변, 높이, 무개
    public Brick(int s, int h, int w){
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) { // 중요
        return o.s - this.s; // 오름차순은 this가 뒤에
    }
}
public class Ten_four {

    public int solution(ArrayList<Brick> arr) {
        int answer = 0;
        int[] dy = new int[arr.size()]; // 컬렉션은 size로 크기를 가져온다.
        Collections.sort(arr); // 오버라이드 메소드로 정렬
        dy[0] = arr.get(0).h; // 첫번째 인덱스의 높이를 가져온다.
        answer = dy[0]; // 이 높이가 가장 클수도 있으니 dy[0]을 넣어놓는다
        for (int i = 1; i < arr.size() ; i++) {
            int max_h = 0; // 앞의 쌓아놓은 벽돌에 해당 벽돌이 들어갔을때 어떤 상황이 제일 높은지 저장한다.
            for (int j = i-1; j >= 0; j--) {
                if(arr.get(j).w > arr.get(i).w && dy[j] > max_h) max_h = dy[j];
            }
            dy[i] = max_h + arr.get(i).h;
            answer = Math.max(answer, dy[i]); // 답을 구하는것 ( 최대 높이)
        }
        return answer;
    }

    public static void main(String[] args) {
        Ten_four T = new Ten_four();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Brick> arr = new ArrayList<>();

        int n = scanner.nextInt(); // 벽돌의 갯수
        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            arr.add(new Brick(s,h,w));
        }
        //Collections.sort(arr, Collections.reverseOrder()); // ArrayList 내림차순 정렬
        System.out.println(T.solution(arr));
    }

}

// 앞 문제와 달리 벽돌의 순서가 따로 존재하지 않고. 그렇기에 정렬을 진행한다.
// 내림차순으로 정렬하여 (뒤에가 무개가 더 가벼울때), 무개를 내림차순으로 정렬해도 (뒤에가 너비가 더 작을때) -> 결과는 같다.
//