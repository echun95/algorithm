package 문제풀이;

import java.io.*;

public class Baekjoon10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 1; i<n; i++){
            int data = Integer.parseInt(br.readLine());
            arr[data] += 1;
        }
        for (int i=0; i < arr.length; i++) {
            for(int j = 0; j < arr[i]; j++){
                bw.write(i + "\n");
            }
        }
    }
}
