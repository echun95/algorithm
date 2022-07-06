package 알고리즘이론.graph;

import java.lang.reflect.Array;
import java.util.*;

public class Dijkstra {


    static class Node{
        private int index;
        private int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int start = 1;
        int v = 6;
        int e = 9;

        //그래프 초기화
        for (int i = 0; i < v+1; i++){
            graph.add(i, new ArrayList<>());
        }
        graph.get(1).add(new Node(2,8));
        graph.get(1).add(new Node(3,1));
        graph.get(1).add(new Node(4,2));
        graph.get(3).add(new Node(2,5));
        graph.get(3).add(new Node(4,2));
        graph.get(4).add(new Node(5,3));
        graph.get(4).add(new Node(6,5));
        graph.get(5).add(new Node(6,1));
        graph.get(6).add(new Node(1,5));

        int[] dist = new int[v+1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 주의점 1. 다익스트라 알고리즘의 최소비용을 기준으로 추출해야 한다. 최대 비용을 기준으로 하는 경우 최악의 경우 지수시간 만큼의 연산을
        // 해야한다!
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        // 시작 노드에서, 시작 노드로 가는 값이 초기에 가장 짧은 비용을 갖는 노드이다.
        // 즉, 도착 정점은 start, 비용은 0인 노드를 가장 먼저 선택할 것이다.
        q.offer(new Node(start, 0));
        // 해당 노드를 선택한 것이나 마찬가지 이므로, dist[start] = 0으로 갱신.
        dist[start] = 0;

        while(!q.isEmpty()){
            Node curNode = q.poll();
            if(dist[curNode.index] < curNode.cost){
                continue;
            }

            for(int i = 0; i < graph.get(curNode.index).size(); i++){
                Node nextNode = graph.get(curNode.index).get(i);
                // 만일, 주변 노드까지의 현재 dist값(비용)과 현재 선택된 노드로부터 주변 노드로 가는 비용을 비교하고, 더 작은 값을 선택한다.
                // 주의점 3 : 중복노드 방지 2 : 만일, 조건문 없이 조건문의 내용을 수행한다면 역시 중복 노드가 발생한다.
                // 간선에 연결된 노드를 모두 넣어준다면 앞서 언급한 정점의 시간 복잡도 VlogV를 보장할 수 없다.
                // 마찬가지로 E^2에 수렴할 가능성이 생긴다. 따라서 이 조건 안에서 로직을 진행해야만 한다.
                if(nextNode.cost + curNode.cost < dist[nextNode.index]){
                    dist[nextNode.index] = nextNode.cost + curNode.cost;
                    q.offer(new Node(nextNode.index, dist[nextNode.index]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
