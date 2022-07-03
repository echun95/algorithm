package 알고리즘이론.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Dfs {

    public static void main(String[] args) {
        //배열의 인덱스와 노드의 번호를 일치하기위해 0 인덱스는 사용 x
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        boolean[] visited = new boolean[11];

//        dfs(1, graph, visited);
        dfs_recursion(1, graph, visited);
    }

    private static void dfs(int start, int[][] graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        //시작 노드를 큐에 넣는다
        stack.push(start);
        //시작 노드를 방문했다고 체크
        visited[start] = true;

        //큐가 빌때까지 반복
        while(!stack.isEmpty()){
            int node_index = stack.pop();
            //탐색 노드 출력
            System.out.print(node_index + " ---->");
            //큐에서 꺼낸 노드와 연결된 노드 검색
            for(int i = 0; i < graph[node_index].length; i++){
                int next = graph[node_index][i];
                //방문한 기록이 없으면
                if(!visited[next]){
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
    }
    private static void dfs_recursion(int start, int[][] graph, boolean[] visited){
        visited[start] = true;
        System.out.print(start + " ----> ");
        for (int node : graph[start]) {
            if(!visited[node]){
                dfs_recursion(node, graph, visited);
            }
        }
    }
}

