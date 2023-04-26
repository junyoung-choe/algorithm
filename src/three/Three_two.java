package three;
import java.util.*;
public class Three_two {
    public ArrayList<Integer> solution(int n, int[] arr1, int m, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);    // 배열이 자동으로 오름차순 정렬이 된다.
        int p1=0 , p2=0;
        while(p1 < n && p2 < m){
            if (arr1[p1] == arr2[p2]){
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
            else if (arr1[p1] < arr2[p2]) p1++;
            else p2++;
        }
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
        Three_two T = new Three_two();
        for (int i : T.solution(n, arr1, m, arr2)){
            System.out.print(i + " ");
        }
    }
}

// Arrays.sort(arr2);    // 배열이 자동으로 오름차순 정렬이 된다.
// 투 포인터 알고리즘 사용했다. p1, p2 를 사용하여 만들었다.