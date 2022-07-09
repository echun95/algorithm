package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        int n = 8;
        int count = 1;
//        int[] test = new int[]{4,3,6,8,7,5,2,1};
        int[] test = new int[n];
        for(int i = 0 ; i < n; i++){
            test[i] = Integer.parseInt(br.readLine());
        }
        boolean check = false;
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        for (int data : test) {
            if(count <= data){
                for(; count < data+1; count++){
                    stack.push(count);
                    result.add("+");
                }
            }
            if(stack.pop() == data){
                result.add("-");
            }else{
                System.out.println("NO");
                check = true;
                break;
            }
        }

        if(!check){
            for (String s : result) {
                System.out.println(s);
            }
        }



    }
}
