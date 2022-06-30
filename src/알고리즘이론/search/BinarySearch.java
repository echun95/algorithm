package 알고리즘이론.search;


public class BinarySearch {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        int search = 9;

        int low = 0;
        int high = data.length - 1;

        boolean check = binary_search(data, search, low, high);
        System.out.println("check = " + check);
    }

    private static boolean binary_search(int[] data, int search, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == search) {
                return true;
            } else if (data[mid] > search) {
                return binary_search(data, search, 0, mid - 1);
            } else {
                return binary_search(data, search, mid + 1, high);
            }
        }
        return false;
    }
}
