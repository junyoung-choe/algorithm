package four;
import java.util.*;
public class Four_five {
    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());  //Collections.reverseOrder() 넣어주면 내림차순 없으면 오름차순.
        for (int i = 0; i < n; i++) {   // n-2 안하는 이유는 어차피 아래 for 문에서 안으로 들어가지 않는다.
            for (int j = i+1; j < n; j++) {  // 중복을 제거하고자 i+1
                for (int l = j+1; l < n; l++) {
                    treeSet.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt = 0;
        // treeSet.remove(143); // 번호가 아닌 존재하는 값중에 143을 제거한다.
        // System.out.println(treeSet.size()); // 원소의 갯수를 알려준다.
        // System.out.println(treeSet.first()); // 제일 처음의 값을 리턴한다 (오름차순, 내림차순에 따라서)
        // System.out.println(treeSet.last()); // 제일 마지막의 값을 리턴한다 (오름차순, 내림차순에 따라서)
        for(int x : treeSet){
            System.out.println(x);
            cnt++;
            if(cnt == k) return x;
            // System.out.println(cnt + " " + x );
        }

        return answer;
    }

    public static void main(String[] args) {
        Four_five T = new Four_five();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(T.solution(n,k,arr));
    }
}





// set 이라는 자료구조를 사용하면 중복을 제거한다. treeset은 보통 중복 제거할때 사용
// 자동 정렬까지 사용하려면 (오름, 내림) SET 중에서 TreeSet을 사용한다. -> Treemap 보통 정렬에 많이 사용한다.
// new TreeSet<>(Collections.reverseOrder());  //Collections.reverseOrder() 넣어주면 내림차순 없으면 오름차순.
// treeSet.remove(143); // 번호가 아닌 존재하는 값중에 143을 제거한다.
// System.out.println(treeSet.size()); // 원소의 갯수를 알려준다.
// System.out.println(treeSet.first()); // 제일 처음의 값을 리턴한다 (오름차순, 내림차순에 따라서)
// System.out.println(treeSet.last()); // 제일 마지막의 값을 리턴한다 (오름차순, 내림차순에 따라서)