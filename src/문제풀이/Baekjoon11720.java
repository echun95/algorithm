package 문제풀이;

import java.io.*;

public class Baekjoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String test = br.readLine();
        int total = 0;
        for(int i = 0; i < N; i++){
            char c = test.charAt(i);
            total += Integer.parseInt(String.valueOf(c));
        }
        bw.append(String.valueOf(total));
        bw.flush();
    }
}
