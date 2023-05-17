package eight;
import java.util.*;
public class Eight_five {
    static int n, limit, min = Integer.MAX_VALUE, times = Integer.MAX_VALUE;
    static int[] arr;
    public void DFS(int L, int sum) {
        if (L >= times || sum > limit) return; // 큰수부터 했기에 먼저 실행한 경우보다 낮은 레벨은 없을거다

        else if (sum == limit) {
            min = Math.min(L,min);
            times = L; // 현재 의 최소의 경로를 저장한다.
            return;
        }
        else {
            for (int i = n-1; i >= 0; i--) { // 오름 차순이니 큰수부터 넣어서 만들어서 가장 작은 경로를 만들기 !
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 사용할 동전의 갯수
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        limit = scanner.nextInt();
        scanner.close();
        Arrays.sort(arr); // 오름차순 으로 만들어서 큰 경우를 먼저 뽑아보기 !!
//        Integer[] arr = new Integer[n]; // 인트 기본형은 내림차순이 안된다
//        Arrays.sort(arr, Collections.reverseOrder()); // 인트 배열을 내림차순으로 만들기
        Eight_five T = new Eight_five();
        T.DFS(0,0);

        System.out.println(min);
    }
}

// DFS는 전체 경우에서 줄일수 있는 경우를 생각하기 !!
//        Arrays.sort(arr); // 오름차순 으로 만들어서 큰 경우를 먼저 뽑아보기 !!
//        Integer[] arr = new Integer[n]; // 인트 기본형은 내림차순이 안된다
//        Arrays.sort(arr, Collections.reverseOrder()); // 인트 배열을 내림차순으로 만들기