package five;
import java.util.*;

public class Five_three {
    public int solution(int n, int[][] broad, int m, int[] moves) { // 컬렉션의 배열은 제작할수 있다.
        Stack<Integer> space = new Stack<>(); // 뽑은 인형이 들어가는것
        Stack<Integer>[] doll = new Stack[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (broad[j][i] != 0)             // 빈공간을 표시하는 0을 제외한 값을 선별
                    doll[i].push(broad[j][i]);    // 각 스택에 broad 배열의 각 열을 넣는다.
            }
        }
        for (int i : moves) {
            if (space.get(space.size() - 1) == doll[i + 1].get(doll[i + 1].size() - 1))
                space.pop();
            else
                space.push(doll[i + 1].pop());          // 각 1~5번 자리의 값을 추출하여 space 스택에 넣는다.
        }
        return space.size();
    }
    public int solution1(int n, int[][] broad, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> space = new Stack<>(); // 뽑은 인형이 들어가는것
        for (int pos : moves) {       // 즉 열을 의미한다.
            for (int i = 0; i < n; i++) { // 행을 의미한다.
                if (broad[i][pos - 1] != 0) {
                    //if (space.size()>0 && space.get(space.size() - 1) == broad[i][pos - 1]) {
                    if (!space.isEmpty() && space.peek() ==  broad[i][pos - 1]){ // 위에 주석이랑 똑같은 효과이다.
                        space.pop();
                        answer += 2;
                    }
                    else
                        space.push(broad[i][pos - 1]);
                    broad[i][pos - 1] = 0;
                    break; // 인형을 뽑은후에 그 밑의 인형은 건드리면 안된다.
                }
            }
        }
        return answer;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 인형 뽑기의 배열의 갯수
        int[][] broad = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                broad[i][j] = scanner.nextInt(); // 인형의 종류
            }
        }
        int m = scanner.nextInt();
        int[] moves = new int[m]; // 물건을 집는 횟수
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt(); // 물건을 잡는 위치
        }
        scanner.close();

        Five_three T = new Five_three();
        System.out.println(T.solution1(n, broad, m, moves));
    }
}

// !space.isEmpty() && space.peek() ==  broad[i][pos - 1]
// isEmpty() 스택이 비었는지 확인한다. peek() 최상위값을 확인만 하는 명령어이다.