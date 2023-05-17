package six;
import java.rmi.dgc.VMID;
import java.util.*;
public class Six_eight {
    public int solution(int n, int m, int[] arr){
        int answer = 0, lt = 0, rt = n-1; // lt와 rt는 양 끝을 가리킨다.
        Arrays.sort(arr);
        while (lt <= rt) {
            int mid = (rt + lt) / 2;  // 이분검색 스타일
            if (arr[mid] == m){
                answer = mid;
                break;
            } else if (arr[mid] > m) rt = mid-1; // mid에 있는 값보다 작은 값이니 이 값도 제외한다.
            else lt = mid+1;                    // mid에 있는 값보다 큰값이니 이 값도 제외한다.
        }
        return answer+1;
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
        Six_eight T = new Six_eight();
        System.out.println(T.solution(n,m,arr));
    }
}

// (binary search)이진 탐색은 해당하지 않는 부분을 다 지우나? 그러면 인덱스를 찾을수 없다.
// 이분 검색은 반드시 정렬이 되어있어야 한다. 시간 복잡도는 순차검색 O(n), 이분검색 (logn)
// two 포인터를 활용하는 방식
