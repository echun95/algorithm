package 문제풀이;

import java.io.*;

public class Baekjoon10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
//        int n = 10;
        int[] test = new int[n];
        int[] count = new int[10001];
        int[] result = new int[n];
        for(int i = 0; i<n; i++){
           test[i] = Integer.parseInt(br.readLine());
           count[test[i]]++;
        }
//        test[0] = 5;
//        test[1] = 2;
//        test[2] = 3;
//        test[3] = 1;
//        test[4] = 4;
//        test[5] = 2;
//        test[6] = 3;
//        test[7] = 5;
//        test[8] = 1;
//        test[9] = 7;
//        for(int i = 0; i < test.length; i++){
//            count[test[i]]++;
//        }
        for(int i = 1; i < count.length; i++){
            count[i] = count[i] + count[i-1];
        }

        for(int i = test.length -1; i >= 0; i--){
            int val = test[i];
            count[val]--;
            result[count[val]] = val;
        }

       for(int i = 0; i < test.length; i++){
          bw.append(result[i] + "\n");
       }
        try {
            bw.flush();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
