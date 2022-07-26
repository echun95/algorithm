package 문제풀이;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[N];
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] check_card = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            check_card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        for(int i = 0; i < check_card.length; i++){
            int target = check_card[i];
            int result = binary_search(target, 0, card.length-1, card);
            bw.append(result + " ");
        }
        bw.flush();
    }

    private static int binary_search(int target, int low, int high, int[] card) {
        if(low > high){
            return 0;
        }
        int midIndex = (low + high)/2;

        if(target == card[midIndex]){
            return 1;
        }
        if(target < card[midIndex]){
            return binary_search(target, 0, midIndex -1, card);
        }else if(target > card[midIndex]){
            return binary_search(target, midIndex + 1, high, card);
        }
        return 0;
    }
}
