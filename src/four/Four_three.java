package four;
import java.util.*;
public class Four_three {
    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n-k+1 ; i++) {
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for (int j = i; j < i+4; j++) {
                hashMap.put(arr[j],hashMap.getOrDefault(arr[j],0)+1);
            }
            answer.add(hashMap.size());
        }
        return answer;
    }

        public ArrayList<Integer> solution1(int n, int k, int[] arr) {     // 투포인트와 윈도우 사용
            ArrayList<Integer> answer = new ArrayList<>();
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            int lt = 0, rt = k;
            for (int i = 0; i < k; i++) {
                hashMap.put(arr[i], hashMap.getOrDefault((arr[i]), 0)+1);
            }
            answer.add(hashMap.size());
            while(rt<n){
                hashMap.put(arr[lt], hashMap.get(arr[lt]) -1);
                if (hashMap.get(arr[lt]) == 0)
                    hashMap.remove(arr[lt]);

                hashMap.put(arr[rt], hashMap.getOrDefault((arr[rt]), 0)+1);
                answer.add(hashMap.size());
                rt++; lt++;
            }
            return answer;
        }


        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Four_three T = new Four_three();
        for (int i : T.solution1(n, k, arr))
            System.out.print(i + " ");
    }
}

// 해쉬함수 , 슬라이딩 윈도우, 투포인터 사용