package 문제풀이;

import java.io.*;

public class Baekjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String test = br.readLine();
        int total = 0;

        String[] split = test.split("-");
        if (split.length == 1) {
            String[] plus = test.split("\\+");
            for (String s : plus) {
                total += Integer.parseInt(s);
            }
            System.out.println(total);
        } else {
            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    total += Integer.parseInt(split[i]);
                    continue;
                }
                if (split[i].indexOf("+") != -1) {
                    String[] sum = split[i].split("\\+");
                    int val = 0;
                    for (String s : sum) {
                        val += Integer.parseInt(s);
                    }
                    total -= val;
                } else {
                    total -= Integer.parseInt(split[i]);
                }
            }
            System.out.println(total);
        }
    }
}
