package 알고리즘이론.recursion;

import java.util.PrimitiveIterator;

public class Example1 {
    public static void main(String[] args) {
        int num = 10;
        int sum = muliple(num);
        int sum2 = recursionMultiple(num);
        System.out.println("sum = " + sum);
        System.out.println("sum2 = " + sum2);

        char[] string = new char[]{'l', 'e', 'v', 'e', 'l'};
        boolean palindrome = palindrome(string);
        System.out.println(string.length / 2);
        System.out.println("palindrome = " + palindrome);

        recursionEx1(3);
    }

    private static int muliple(int num) {
        int sum = 1;
        for (int i = 1; i < num + 1; i++) {
            sum = sum * i;
        }
        return sum;
    }

    private static int recursionMultiple(int num) {
        if (num <= 1) {
            return num;
        }
        return num * recursionMultiple(num - 1);
    }

    private static boolean palindrome(char[] string) {
        for (int i = 0; i < string.length / 2; i++) {
            if (string[i] != string[string.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int recursionEx1(int num) {
        System.out.println(num);
        if (num == 1) {
            return num;
        } else if (num % 2 == 0) {
            return recursionEx1(num / 2);
        } else {
            return recursionEx1(3 * num + 1);
        }
    }
}
