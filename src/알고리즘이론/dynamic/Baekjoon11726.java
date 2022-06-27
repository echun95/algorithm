package 알고리즘이론.dynamic;

public class Baekjoon11726 {

    public static void main(String[] args) {
        int n = 3;
        int[] sum = new int[n+2];

        sum[1] = 1;
        sum[2] = 2;

        for(int i=3; i<n+1; i++){
            sum[i] = sum[i-1] + sum[i-2];
        }
        System.out.println("sum[n] = " + sum[n]%1007);

    }
}
