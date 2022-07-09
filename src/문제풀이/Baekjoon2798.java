package 문제풀이;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int card_len = Integer.parseInt(st.nextToken());
        int black_jack = Integer.parseInt(st.nextToken());
        int[] cards = new int[card_len];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < card_len; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for(int i=0; i < card_len-2; i++){
            for(int j = i+1; j < card_len-1; j++){
                for (int k = j + 1; k < card_len; k++){
                    int hap = cards[i] + cards[j] + cards[k];
                    if(hap <= black_jack){
                        if (hap >= sum) {
                            sum = hap;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
