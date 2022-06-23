package 알고리즘이론.dynamic;

public class Fibonacci {
    public static void main(String[] args) {
        int fibo = fibo(4);
        System.out.println("fibo = " + fibo);
        int fibo_db = fibo_dp(4);
        System.out.println("fibo_db = " + fibo_db);
    }

    private static int fibo(int num) {
        if (num <= 1) {
            return num;
        }
        return fibo(num - 1) + fibo(num - 2);
    }

    private static int fibo_dp(int num) {
        int[] cache = new int[num + 1];
        for (int i = 0; i < num; i++) {
            cache[i] = 0;
            if (i == 1) {
                cache[i] = 1;
            }
        }
        for (int i = 2; i < num + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[num];
    }
}
