package 알고리즘이론.dynamic;

public class Baekjoon9461 {
    public static void main(String[] args) {
        int n = 4;
        int[] sum = new int[n+2];
        sum[0] = 1;
        sum[1] = 1;
        sum[2] = 1;

        for(int i = 3; i < sum.length; i++){
            sum[i] = sum[i-2] + sum[i-3];
        }
        System.out.println(sum[n-1]);
    }
}
