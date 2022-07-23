package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = 5;
        int[] test = new int[N];
        for(int i = 0; i < test.length; i++){
            test[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;
        int result = 0;
        Arrays.sort(test);
        for (int i : test) {
            total = total + i;
            result += total;
        }
        System.out.println(result);
    }
}
