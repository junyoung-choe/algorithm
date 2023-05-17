package six;
import java.util.*;
public class Six_six {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (arr[0] > arr[1]) answer.add(arr[0]);
        for (int i = 1; i < n-1; i++)
            if (arr[i] < arr[i-1] || arr[i] > arr[i+1]) answer.add(arr[i]);
        if (arr[n-1] < arr[n-2]) answer.add(n-1);

        return answer;
    }
    public ArrayList<Integer> solution1(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
//        int[] tmp = new int[n];
//        for (int i = 0; i < n; i++) {
//            tmp[i] = arr[i];
//        }
        int[] tmp = arr.clone();  // 위 과정을 한줄로 대체한다.
        Arrays.sort(tmp); // 배열을 정리한다.
        for (int i = 0; i < n; i++) {
            if (tmp[i] != arr[i]) answer.add(i+1);
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        scanner.close();

        Six_six T = new Six_six();
        for (int i : T.solution1(n, arr))
            System.out.print(i + " ");
    }
}
