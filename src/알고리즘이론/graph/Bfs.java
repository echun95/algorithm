package 알고리즘이론.graph;

import java.util.*;

public class Bfs {

    public static void main(String[] args) {
        //배열의 인덱스와 노드의 번호를 일치하기위해 0 인덱스는 사용 x
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        boolean[] visited = new boolean[11];

        bfs(1, graph, visited);
    }

    private static void bfs(int start, int[][] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        //시작 노드를 큐에 넣는다
        queue.offer(start);
        //시작 노드를 방문했다고 체크
        visited[start] = true;

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            int node_index = queue.poll();
            //탐색 노드 출력
            System.out.print(node_index + " ---->");
            //큐에서 꺼낸 노드와 연결된 노드 검색
            for(int i = 0; i < graph[node_index].length; i++){
                int next = graph[node_index][i];
                //방문한 기록이 없으면
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}

