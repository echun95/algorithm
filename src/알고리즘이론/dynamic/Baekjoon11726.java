package 알고리즘이론.dynamic;

public class Baekjoon11726 {

    public static void main(String[] args) {
        int n = 9;
        int[] sum = new int[n];

        sum[0] = 1;
        sum[1] = 2;

        for(int i=2; i<n; i++){
            sum[i] = sum[i-1] + sum[i-2];
        }
        System.out.println("sum[n] = " + sum[n-1]%1007);

    }
}
