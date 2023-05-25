package nine;

import java.util.*;
class Nine_six_well {
    static int[] unf; // 학생의 번호의 배열
    public static int Find(int v){ // 학생의 번호가 들어온다.
        if(v==unf[v]) return v; // 학생 번호의 집합을 리턴한다 !
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa=Find(a);
        int fb=Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt(); // 학생 명수와 번호
        int m=kb.nextInt();     // 학생의 친구 쌍의 갯수
        unf=new int[n+1];       // 학생 번호로 인덱스를 맞추며 배열을 생성한다.

        for(int i=1; i<=n; i++) unf[i]=i;

        for(int i=1; i<=m; i++){ // 학생의 친구 쌍을 입력받는다
            int a=kb.nextInt();
            int b=kb.nextInt();
            Union(a, b); // Union은 a와 b를 한 집합으로 만들어라 하는 명령이다 !
        }

        int a=kb.nextInt();
        int b=kb.nextInt();
        int fa=Find(a);
        int fb=Find(b);
        if(fa==fb) System.out.println("YES");
        else System.out.println("NO");
    }
}

// 집합을 만들어서 같은 집합에 있는지 확인하는것이다 !