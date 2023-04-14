package two;
import java.util.Scanner;
import java.util.WeakHashMap;

public class Two_two {

    public int solution(int size, int height[]) {  // for 문 2개쓰면 비효율 ! -> Max 사용해야해 !!
        int height_Max = height[0];
        int people = 1;                  // 맨 앞 학생을 무조건 보인다 !

        for (int i = 1; i < size; i++) {
            if(height[i] > height_Max) {
                people++;
                height_Max = height[i];
            }
        }
        return people;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int height[] = new int[size];
        for (int i = 0; i < size; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();

        Two_two T = new Two_two();
        System.out.println(T.solution(size, height));
    }
}
