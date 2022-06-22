package 알고리즘이론.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = new int[]{5,3,1,4,6};
        selectionSort(list);
        print(list);
    }

    private static void selectionSort(int[] list) {
        for(int i = 0; i < list.length; i++){
            int index=i;
            for(int j = 1 + i; j < list.length; j++){
                if(list[index] > list[j]){
                    index = j;
                }
            }
            swap(list, i, index);
        }
    }

    private static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] list, int i, int index) {
        int temp;
        temp = list[i];
        list[i] = list[index];
        list[index] = temp;
    }


}
