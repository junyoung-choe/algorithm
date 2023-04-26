package three;
import java.util.*;

public class Three_one {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while (p1 < n && p2 < m ){ // 2개다 참일때 동작하는 것이니 둘중 하나만 거짓이여도 while이 멈춘다
            if(arr1[p1]<arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while (p1 < n) answer.add(arr1[p1++]); // 둘중 남아있는 배열을 한꺼번에 집어넣는다.
        while (p2 < m) answer.add(arr2[p2++]);
        return answer;
    }

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int n = scanner.nextInt();
         int[] arr1 = new int[n];
         for (int i = 0; i < n; i++) {
             arr1[i] = scanner.nextInt();
         }
         int m = scanner.nextInt();
         int[] arr2 = new int[m];
         for (int i = 0; i < m; i++) {
             arr2[i] = scanner.nextInt();
         }
         scanner.close();
         Three_one T = new Three_one();
         for (int i : T.solution(n, arr1, m, arr2)){
             System.out.print(i + " ");
         }
    }

}
// 두 배열을 합쳐서 정렬을 한다면 ? ->
// 투 포인터쓰 알고리즘을 구현할수 잇냐? 를 물어보는것이다.
// 퀵정렬 -> n logn
// 투 포인트 정렬 -> n
// 배열 두개의 인덱스를 돌아가면서 증가시키며, while문 안에 넣는다.