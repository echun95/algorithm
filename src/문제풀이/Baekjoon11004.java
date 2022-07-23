package 문제풀이;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
//        int N = 9;
        int K = Integer.parseInt(st.nextToken());
//        int K = 5;
        int[] test = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            test[i] = (Integer.parseInt(st.nextToken()));
        }
//        test[0] = 4;
//        test[1] = 1;
//        test[2] = 2;
//        test[3] = 3;
//        test[4] = 5;
//        test[5] = 8;
//        test[6] = 7;
//        test[7] = 6;
//        test[8] = 9;
        int result = quickSelect(test, K-1, 0, test.length-1);
//        System.out.println(result);
        bw.write(result);
    }

    public static int quickSelect(int[] arr, int key, int left, int right){
        if(right - left <= 0){
            return arr[key];
        }
        int sortedIndex = partition(arr, left, right);
        if (sortedIndex < key) {
            return partition(arr, sortedIndex + 1, right);
        } else if (sortedIndex > key) {
            return partition(arr, left, sortedIndex - 1);
        }else{
            return arr[sortedIndex];
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotVal = arr[right];
        int pivotIndex = right;
        right--;

        while(true){
            while(arr[left] < pivotVal){
                left++;
            }
            while(arr[right] > pivotVal){
                right--;
            }
            if(right <= left){
                break;
            }
            swap(arr, left, right);
        }

        swap(arr, left, pivotIndex);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
