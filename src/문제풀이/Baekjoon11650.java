package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon11650 {
    static class Node {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(node);
        }
        list.sort(Comparator.comparing(Node::getX).thenComparing(Node::getY));
        for (Node node : list) {
            System.out.println(node.x + " " + node.y);
        }
    }
}
