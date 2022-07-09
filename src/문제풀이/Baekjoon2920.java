package 문제풀이;

import java.io.*;

public class Baekjoon2920 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] s = bf.readLine().split(" ");

        boolean asc_chk = false;
        boolean desc_chk = false;
        String out;

        int[] asc = new int[]{1,2,3,4,5,6,7,8};
        int[] desc = new int[]{8,7,6,5,4,3,2,1};
        int[] mix = new int[]{1,4,5,2,5,6,7,3};
        int[] test = mix;
//        int[] test = new int[s.length];

//        for(int i = 0; i < s.length; i++){
//            test[i] = Integer.parseInt(s[i]);
//        }

        for (int i = 0; i < test.length - 1; i++){
            if(test[i] < test[i+1]){ //asc
                asc_chk = true;
            }
            else if(test[i] > test[i+1]){ //desc
                desc_chk = true;
            }else{
                asc_chk = false;
                desc_chk = false;
            }
        }
        if(asc_chk == desc_chk){
            out = "mixed";
        }else if(asc_chk){
            out = "ascending";
        }else {
            out = "descending";
        }
        System.out.println(out);

    }
}
