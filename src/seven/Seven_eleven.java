package seven;

public class Seven_eleven {
}


// 그래프와 인접행렬
// G(V,E) 버택스 -> 노드를 의미 | 엣지 -> 간선을 의미한다.
// 1과2가 연결되어 있다면 -> 1, 2 이렇게 입력이 들어온다.
// 무방향 그래프(양방향 그래프 양쪽으로 다 왔다갔다 할수 있다.)
// (1, 2) 입력값이 들어온다면, 2차원 graph에 1,2와 2,1 둘다 기록한다는 생각 | graph[1][2] = 1 , graph[2][1] = 1;
// 방향 그래프 (그래프에 방량이 존재한다.)
// (1, 2) 입력값이 들어온다면, 2차원 graph에 1,2 만 들어간다는 생각 | graph[1][2] = 1 만
// 가중치 방향 그래프 (방향 그래프에 특정 값이 같이 넘어간다.)
// (1, 2, 5) 5는 가중치이다. -> graph[1][2] = 5 그래프 내부의 값을 가중치로 넣는다.