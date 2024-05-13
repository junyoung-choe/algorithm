// weights 의 길이는 100000 으로 n^2 은 불가능 
// 즉 n의 횟수에서 정리가 필요하다 ! 
// 하나의 for 문으로 해결해야 한다 ! 
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        HashMap<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);
        
        // 정렬을 진행하게 되면 
        // case 1 i 번째 숫자와 같은 숫자가 있는경우 
        // case 2 i 번째 숫자의 2/3 경우
        // case 3 i 번째 숫자의 2/4 경우
        // case 4 i 번째 숫자의 3/4 경우
        // 해당 횟수들이 정답이 된다 
        // 앞의 숫자들은 i 번째 숫자보다 무적권 작기에 큰 경우를 고려하지 않아도 된다 
        // 즉 앞의 숫자들은 원본을 그대로 넣는것이 생각의 전환점이다 ! 
        
        for(double weight : weights) {
            if(map.containsKey(weight*(1.0))) answer += map.get(weight*(1.0));
            if(map.containsKey(weight*(1.0) * 2/3)) answer += map.get(weight*(1.0) * 2/3);
            if(map.containsKey(weight*(1.0) * 2/4)) answer += map.get(weight*(1.0) * 2/4);
            if(map.containsKey(weight*(1.0) * 3/4)) answer += map.get(weight*(1.0) * 3/4);
            map.put(weight*(1.0) ,map.getOrDefault(weight,0)+1);
        }
        
        
        return answer;
    }
}
// 66 이라는 무개가 존재할때 
// 100 이라는 무개가 있는 사람이 3으로 나눈 66 이 정답이 되버린다 
// 소수처리를 위해서 double 을 사용한적은 있지만 int 형만 답이 되기위한 double의 사용이다 ! 