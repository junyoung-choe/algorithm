package two;

import java.util.Scanner;

public class Two_ten {

    public int solution1(int size, int[][] cross) { // 선생님 작성
        int[] dx = {-1, 0, 1, 0};         // 미리 [-1][0], [0][1], [1][0], [0][-1] 짝을 제작한다 !! 중요하다 !!
        int[] dy = { 0, 1, 0,-1};
        int answer = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean flag= true;
                for ( int k=0; k<4; k++){
                    if ((i+dx[k]) >= 0 && (i+dx[k]) < size && (j+dy[k]) >= 0 && (j+dy[k]) < size
                            // 위에꺼를 반드시 먼저 써야한다 앞에 조건을 만족한 후에 뒤에 조건을 쓰는것이기에 앞에게 기초이다. 이게 즉 경계선 0으로 가정한것이랑 같다 !
                    && cross[i][j]<cross[i+dx[k]][j+dy[k]]){ // 만들어놓은 짝을 사용한다.
                        flag = false;
                        break; // 현재 있는 for 문을 탈출한다.
                    }
                }
                if (flag) answer++;         // flag == true 안써도 어차피 flag가 ture or false 그 자체를 의미한다.
            }
        }
        return answer;
    }
    public int solution2(int size, int[][] cross) { // 준영 작성
        int answer = 0;
        int max = 0;
        int[][] cmp = new int[size + 2][size + 2];
        for (int i = 0; i < size+2; i++) {
            for (int j = 0; j < size+2; j++)
                cmp[i][j] = 0;
        }

        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < size+1; j++) {
                cmp[i][j] = cross[i-1][j-1];
            }
        }
        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j < size+1; j++) {
                max = Math.max(cmp[i-1][j], cmp[i+1][j]);
                max = Math.max(max, cmp[i][j-1]);
                max = Math.max(max, cmp[i][j+1]);
                max = Math.max(max, cmp[i][j]);
                if (max == cmp[i][j]) answer++;
                max = 0;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] cross = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cross[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        Two_ten T = new Two_ten();
        System.out.println(T.solution1(size, cross));
    }
}

//if ((i+dx[k]) >= 0 && (i+dx[k]) < size && (i+dy[k]) >= 0 && (i+dy[k]) < size
//                            // 위에꺼를 반드시 먼저 써야한다 앞에 조건을 만족한 후에 뒤에 조건을 쓰는것이기에 앞에게 기초이다.
//                    && cross[i][j]<cross[i+dx[k]][i+dy[k]]){ // 만들어놓은 짝을 사용한다.

//    int[] dx = {-1, 0, 1, 0};         // 미리 [-1][0], [0][1], [1][0], [0][-1] 짝을 제작한다 !! 중요하다 !!
//   int[] dy = { 0, 1, 0,-1};          // 이렇게 사용해야 반복문에서 활용할수 있다는 생각하기 !!!!!!!!!! 일일이 비교하지 않을수 있다 (큰수를)