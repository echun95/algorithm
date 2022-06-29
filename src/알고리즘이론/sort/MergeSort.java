package 알고리즘이론.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(1);
        data.add(6);
        data.add(5);
        data.add(8);
        data.add(4);

        //split
        List<Integer> merged = merge_sort(data);
        System.out.println("merged = " + merged);
    }

    private static List<Integer> merge_sort(List<Integer> data) {
        if(data.size() <= 1){
            return data;
        }
        int mid = (data.size()-1)/2;
        List<List<Integer>> lists = new ArrayList<>(
                data.stream()
                        .collect(Collectors.groupingBy(s -> data.indexOf(s) > mid))
                        .values()
        );
        List<Integer> left = merge_sort(lists.get(0));
        List<Integer> right = merge_sort(lists.get(1));

        return merge(left,right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<Integer> result = new ArrayList<>();
        //case 1
        while (left.size() > leftIndex && right.size() > rightIndex) {
            if(left.get(leftIndex) < right.get(rightIndex)){
                result.add(left.get(leftIndex));
                leftIndex++;
            }else{
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        //case 2 left만 남았을때
        while(left.size() > leftIndex){
            result.add(left.get(leftIndex));
            leftIndex++;
        }
        //case 3 right만 남았을때
        while(right.size() > rightIndex){
            result.add(right.get(rightIndex));
            rightIndex++;
        }
        return result;
    }
}
