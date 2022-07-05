package 알고리즘이론.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Baekjoon11399 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(4);
        list.add(3);
        list.add(2);

        int min_value = min(list);
        System.out.println("min_value = " + min_value);
    }

    private static int min(List<Integer> list) {
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        int delay = 0;
        int total_delay = 0;
        for (int i = 0; i < sorted.size(); i++){
            if(i == 0){
                delay = sorted.get(i);
                total_delay = sorted.get(i);
                continue;
            }
            delay = delay + sorted.get(i);
            total_delay += delay;
        }


        return total_delay;
    }
}
