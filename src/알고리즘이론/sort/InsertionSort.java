package 알고리즘이론.sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] list = new int[]{5,3,2,4};
        insertionSort(list);
        print(list);
    }

    private static void insertionSort(int[] list) {
        for(int i = 1; i < list.length; i++){
            int num = list[i];
            for(int j = i-1; j > -1; j--){
                //swap
                if(num < list[j]){
                    swap(list, j);
                }else{
                    break;
                }
            }
        }
    }

    private static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] list, int j) {
        int temp = list[j +1];
        list[j +1] = list[j];
        list[j] = temp;
    }
}
