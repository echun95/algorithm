package 알고리즘이론.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(6);
        data.add(1);
        data.add(2);
        data.add(7);

        List<Integer> sorted = quickSort(data);
        System.out.println(sorted);
    }

    private static List<Integer> quickSort(List<Integer> data){
        if(data.size() <= 1){
            return data;
        }
        int pivot = data.get(data.size()/2);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();

        for (Integer num : data) {
            if(pivot < num){
                right.add(num);
            }else if(pivot > num){
                left.add(num);
            }else{
                equal.add(pivot);
            }
        }
        return Stream.of(quickSort(left), equal, quickSort(right))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
