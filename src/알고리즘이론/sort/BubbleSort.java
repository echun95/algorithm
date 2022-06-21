package 알고리즘이론.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = new int[]{3,4,5,1,6,8,9,7,10,2};
        bubbleSort(list);
        print(list);
    }

    private static void print(int[] list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    private static void bubbleSort(int[] list) {
        for(int i = 0; i < list.length-1; i++){
            boolean swap = false;
            for(int j = 0; j < list.length-1-i; j++){
                //스왑
                if(list[j] > list[j+1]){
                    swap = swap(list, j, j + 1);
                }
            }
            if(swap == false){
                break;
            }
        }
    }

    private static boolean swap(int[] list, int i, int j) {
        int temp;
        temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        return true;
    }
}
