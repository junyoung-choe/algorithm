package nine;
import java.util.*;

public class Nine_six {
    static ArrayList<ArrayList<Integer>> arr;
    static int n, m, friend;
    static String answer;
    static boolean flag;
    public void DFS(int a) {
        if (flag) return;
        if (a == friend) {
            answer = "YES";
            flag = true;
        }
        else {
            for (int i : arr.get(a))
                DFS(i);
        }
    }
    public static void main(String[] args) {
        Nine_six T = new Nine_six();
        Scanner sc = new Scanner(System.in);
        answer = "NO";
        flag = false; // 메모리 제이션을 위해서

        n = sc.nextInt(); // 학생수이자 학생 번호
        m = sc.nextInt(); // 친구 짝의 갯수

        arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) { // 0번 인덱스의 ArrayList는 사용하지 않는다.
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) { // ㅈm개의 짝을 입력받는다
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
        }

        int me = sc.nextInt(); // 친구를 확인하는 두명을 입력 받는다
        friend = sc.nextInt();
        T.DFS(me);
        System.out.println(answer);
    }
}

// 처음에 DFS() 앞에 String으로 선언하여 return을 했지만
// 이 경우 바로 T.DFS(me); 호출부로 돌아오는 것이 아닌 스택을 다 마치고 난뒤 복귀한다 ! 그러므로 void로 선언해야 한다.
// 팩토리얼 같은 DFS 에서 return 을 int 형으로 하는것이다 !!!!!!!!

