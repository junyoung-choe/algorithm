package two;
import java.util.*;
public class Two_nine {
    public int solution(int size, int[][] cross) {
        int max = 0;
        int tmp = 0, tmp2 = 0;

        for (int i = 0; i < size; i++) { // 행의 합
            for (int j = 0; j < size; j++) {
                tmp += cross[i][j];
            }
            if ( max < tmp) max = tmp;
            tmp = 0;
        }

        for (int i = 0; i < size; i++) { // 열의 합
            for (int j = 0; j < size; j++) {
                tmp += cross[j][i];
            }
            //if ( max < tmp) max = tmp;
            max = Math.max(tmp, max);    // 둘중 더 큰값이 들어간다.
            tmp = 0;
        }
        // 위 두 행렬을 합쳐서 한번에 구할수 있다 !!
        for (int i = 0; i < size; i++) { // 대각선 1,2 합친것 !
            tmp += cross[i][i];
            tmp2 += cross[i][size-1-i];
        }
        if ( max < tmp) max = tmp;
        max = Math.max(tmp2, max);
        return max;
        /*
        for (int i = 0; i < size; i++) { // 대각선 1
            tmp += cross[i][i];
        }
        if ( max < tmp) max = tmp;
        tmp = 0;

        int lt=0, rt= size-1;  // 대각선 2
        while(lt > size){
            tmp += cross[lt][rt];
            lt++;
            rt--;
        }
        if ( max < tmp) max = tmp;
        return max;
        */
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

        Two_nine T = new Two_nine();
        System.out.println(T.solution(size, cross));
    }
}

// 이중 포문 두개를 합칠수 있다면 합쳐보자 !! 중요하다 !
// max = Math.max(tmp, max)    // 둘중 더 큰값이 들어간다.