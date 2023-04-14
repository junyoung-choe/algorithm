package two;
import java.util.ArrayList;
import java.util.Scanner;
public class Two_one {

    public ArrayList<Integer> solution(int size, int number[]){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(number[0]);

        for (int i = 1; i < size; i++) {
            if(number[i] > number[i-1]) answer.add(number[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int number[] = new int[size];
        for (int i = 0; i < size; i++) {
            number[i] = scanner.nextInt();
        }
        scanner.close();

        Two_one T = new Two_one();
        for (int i : T.solution(size, number))
            System.out.print(i + " ");
    }
}

// for( : ) 문 뒤에는 배열 or 컬렉션만 가능하다.
// solutions을 보낸 결과를 컬렉션으로 받는다.
// for (int i : T.solution(size, number)) 여기서의 T.solution() 은 ArrayList를 리턴 받는다.