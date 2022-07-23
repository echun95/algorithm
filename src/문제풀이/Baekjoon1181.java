package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Baekjoon1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i <N; i++){
            set.add(br.readLine());
        }
//        String test0 = "but";
//        String test1 = "i";
//        String test2 = "wont";
//        String test3 = "hesitate";
//        String test4 = "no";
//        String test5 = "more";
//        String test6 = "no";
//        String test7 = "more";
//        String test8 = "it";
//        String test9 = "cannot";
//        String test10 = "wait";
//        String test11 = "im";
//        String test12 = "yours";
//
//        set.add(test0);
//        set.add(test1);
//        set.add(test2);
//        set.add(test3);
//        set.add(test4);
//        set.add(test5);
//        set.add(test6);
//        set.add(test7);
//        set.add(test8);
//        set.add(test9);
//        set.add(test10);
//        set.add(test11);
//        set.add(test12);
//
        List<String> list = set.stream().collect(Collectors.toList());

        Collections.sort(list, ((o1, o2) -> {
            if(o1.length() < o2.length()){
                return -1;
            }else if(o1.length() > o2.length()){
                return 1;
            }else{
                return o1.compareTo(o2);
            }
        }));
        for (String s : list) {
            System.out.println(s);
        }
    }
}
