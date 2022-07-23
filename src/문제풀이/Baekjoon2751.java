package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2751 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
        int[] test = new int[]{5,4,3,2,1};
//        for(int i = 0; i < N; i++){
//            test[i] = (Integer.parseInt(br.readLine()));
//        }

        int[] sort = countingSort(test);
        for(int i = 0; i < sort.length -1; i++){
            System.out.println(sort[i]);
        }


    }

    private static int[] countingSort(int[] test) {
        int[] countingArray = new int[test.length +1];
        int[] result= new int[test.length+1];

       for(int i = 0; i <test.length; i++){
           countingArray[test[i]]++;
       }
       //누적
        for(int i = 1; i<countingArray.length; i++){
            countingArray[i] = countingArray[i] + countingArray[i-1];
        }
        //계산
        for(int i = test.length -1; i >= 0; i--){
            int val = test[i];
            countingArray[val]--;
            result[countingArray[val]] = val;
        }
        return result;
    }

}
