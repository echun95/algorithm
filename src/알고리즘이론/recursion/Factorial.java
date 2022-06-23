package 알고리즘이론.recursion;

public class Factorial {
    public static void main(String[] args) {
        int factorial = factorial(10);
        System.out.println("factorial = " + factorial);
    }

    private static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
