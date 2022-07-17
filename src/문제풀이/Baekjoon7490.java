package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Baekjoon7490 {

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            n = Integer.parseInt(br.readLine());
            recursion(1,1,"1");
            System.out.println();
        }


    }

    static void recursion(int num, int len, String str){
        if(len == n){
            calc(str);
            return;
        }

        recursion(num + 1, len + 1, str + "+" + (num + 1));
        recursion(num + 1, len + 1, str + "-" + (num + 1));
        recursion(num + 1, len + 1, str + " " + (num + 1));
    }

    private static void calc(String str) {
        String temp = str.replaceAll(" ", "");

        Iterator<Integer> integers = Arrays.stream(temp.split("[+,-]"))
                .map(Integer::parseInt)
                .collect(toList()).iterator();
        int result = integers.next();
        for(int i = 0; i < temp.length(); i++){
            if(temp.charAt(i) == '+'){
                result = result + integers.next();
            }else if(temp.charAt(i) == '-'){
                result = result - integers.next();
            }
        }
        if(result == 0){
            System.out.println(str);
        }
    }
}
