class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            int now = storey % 10;
            storey /= 10;
            
            if (now > 5) {
                // 이 부분이 틀린 요인 1
                // answer += (10-now) + 1;
                answer += (10-now);
                storey++;
            } else if (now < 5){
                answer += now;
                // 틀린부분 2 > 가 아니라 >= 를 적었어야 했다
            } else if (storey % 10 >= 5) {
                // 십의 자리 숫자의 연산을 줄여준다 !  이건 십의자릴 숫자 ++해준는게 이득
                answer += 5;
                storey++;
            } else {
                // 즉 이건 십의 자리 숫자를 그대로 두는 것이 이득
                answer += 5;
            }
        }
        
        return answer;
    }
}

// 그리디 문제인건 감이왔지만
// 각 자리만 계산하면 된다고 생각했다 ! 
// 1의 자리 숫자가 5인 경우에는 두가지를 더 고려해야 한다
// 15 와 55인 경우를 생각해보자 