package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2747 {

    public static int fibo(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        for(int i = 2; i < n+1; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = fibo(n);
        System.out.println(result);
    }
}
