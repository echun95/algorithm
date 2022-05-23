package 자료구조;
import java.util.*;
public class QueueExample {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("1el");
        queue.add("2el");
        System.out.println("queue = " + queue.poll());
        System.out.println("queue = " + queue.size());
    }
}
