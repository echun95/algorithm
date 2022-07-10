package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_cnt = Integer.parseInt(br.readLine());
        for(int i=0; i<test_cnt; i++){
            Stack<String> left_stack = new Stack<>();
            Stack<String> right_stack = new Stack<>();

            String[] test = br.readLine().split("");
            for (String text : test) {
                if(text.equals("<")){
                    if(!left_stack.isEmpty()){
                        right_stack.push(left_stack.pop());
                    }
                }
                else if(text.equals(">")){
                    if(!right_stack.isEmpty()){
                        left_stack.push(right_stack.pop());
                    }
                } else if (text.equals("-")){
                    if(!left_stack.isEmpty()){
                        left_stack.pop();
                    }
                }else{
                    left_stack.push(text);
                }
            }
            while(!left_stack.isEmpty()){
                right_stack.push(left_stack.pop());
            }
            while(!right_stack.isEmpty()){
                sb.append(right_stack.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
