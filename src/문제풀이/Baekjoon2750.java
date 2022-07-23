package 문제풀이;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Baekjoon2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> test = new ArrayList<>();
        for(int i = 0; i < N; i++){
            test.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> result = merge_sort(test);
        for (Integer integer : result) {
            bw.write(integer + "\n");
        }
    }

    private static List<Integer> merge_sort(List<Integer> test) {
        if(test.size() <= 1){
            return test;
        }

        int midIndex = (test.size()-1)/2;
        List<List<Integer>> lists = new ArrayList<>(
                test.stream()
                        .collect(Collectors.groupingBy(s -> test.indexOf(s) > midIndex))
                        .values()
        );
        List<Integer> left = merge_sort(lists.get(0));
        List<Integer> right= merge_sort(lists.get(1));

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while(left.size() > i && right.size() > j){
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
        }else if(j == right.size()){
            while(i < left.size()){
                result.add(left.get(i));
                i++;
            }
        }
        return result;
    }

}
