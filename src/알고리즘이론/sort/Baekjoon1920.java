package 알고리즘이론.sort;

import java.util.Arrays;

public class Baekjoon1920 {
    public static void main(String[] args) {
        int[] data = new int[]{4,1,5,2,3};
        int[] search_data = new int[]{1,3,7,9,5};
        Arrays.sort(data);

        int low = 0;
        int high = data.length -1;
        for(int i = 0; i < search_data.length; i++){
            int result = binary_search(data, search_data[i], low, high);
            System.out.println("result = " + result);
        }
    }

    private static int binary_search(int[] data, int search_data, int low, int high) {
        if(low <= high){
            int mid = (low + high) / 2;
            if(data[mid] == search_data){
                return 1;
            }else if(data[mid] > search_data){
                return binary_search(data, search_data, 0, mid -1);
            }else
                return binary_search(data,search_data, mid+1, high);
        }
        return 0;
    }
}
