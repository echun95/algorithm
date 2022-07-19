package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Baekjoon2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> test = new ArrayList<>();
        for(int i = 0; i < N; i++){
            test.add(Integer.parseInt(br.readLine()));
        }
//        test.add(5);
//        test.add(4);
//        test.add(3);
//        test.add(2);
//        test.add(1);
        List<Integer> sort = sort(test);
        for (Integer integer : sort) {
            System.out.println(integer);
        }


    }

    private static List<Integer> sort(List<Integer> test) {
        if(test.size() <= 1){
            return test;
        }
        int mid = (test.size()-1)/2;
        List<Integer> result = new ArrayList<>();
        List<Integer> left;
        List<Integer> right;
        List<List<Integer>> array = new ArrayList<>(test.stream().
                collect(Collectors.partitioningBy(s -> test.indexOf(s) > mid))
                .values());
        left = sort(array.get(1));
        right = sort(array.get(0));
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()){
            if(left.get(i) < right.get(j)){
                result.add(left.get(i));
                i++;
            }else{
                result.add(right.get(j));
                j++;
            }
        }
        if(i == left.size()){
            while(j < right.size()){
                result.add(right.get(j));
                j++;
            }
        }else{
            while(i < left.size()){
                result.add(left.get(i));
                i++;
            }
        }

        return result;
    }

//    private static List<Integer> sort(List<Integer> test, int low, int high) {
//        if(test.size() == 1){
//            return test;
//        }
//        if(low >= high){
//            return test;
//        }
//        int mid = (low + high)/2;
//        List<Integer> left = new ArrayList<>();
//        List<Integer> right = new ArrayList<>();
//        List<Integer> middle = new ArrayList<>();
//
//        for(int i = 0; i < test.size(); i++){
//            if(test.get(i) < test.get(mid)){
//                left.add(test.get(i));
//            }else if(test.get(i) > test.get(mid)){
//                right.add(test.get(i));
//            }else {
//                middle.add(test.get(i));
//            }
//        }
//        List<Integer> sorted =
//                Stream.of(sort(left, 0, left.size()), middle, sort(right, 0, right.size()))
//                        .flatMap(Collection::stream)
//                        .collect(Collectors.toList());
//
//        return sorted;
//    }
    
    
    
    
}
