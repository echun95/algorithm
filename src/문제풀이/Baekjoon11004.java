package 문제풀이;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Baekjoon11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> test = new ArrayList<>();


        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            test.add(Integer.parseInt(st.nextToken()));
        }
        test.sort(Integer::compareTo);

//        List<Integer> sort = sort(test);

        bw.write(test.get(K));
    }

    private static List<Integer> sort(List<Integer> test) {
        if (test.size() <= 1) {
            return test;
        }

        List<Integer> left;
        List<Integer> right;
        int mid = (test.size() - 1) / 2;

        List<List<Integer>> array = new ArrayList<>(test.stream()
                .collect(Collectors.partitioningBy(s -> test.indexOf(s) > mid))
                .values());
        left = sort(array.get(0));
        right = sort(array.get(1));

        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < left.size() && j < right.size()){
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
}
