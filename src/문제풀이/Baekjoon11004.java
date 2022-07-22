package 문제풀이;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon11004 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
        int N = 5;
//        int K = Integer.parseInt(st.nextToken());
        int K = 2;
        int[] test = new int[N];

//        st = new StringTokenizer(br.readLine(), " ");
//        for(int i = 0; i < N; i++){
//            test[i] = (Integer.parseInt(st.nextToken()));
//        }
        test[0] = 4;
        test[1] = 1;
        test[2] = 2;
        test[3] = 3;
        test[4] = 5;
        int result = quickSelect(test, K-1, 0, test.length-1);
        System.out.println(result);
//        bw.write(index);
    }

//    private static List<Integer> sort(List<Integer> test) {
//        if (test.size() <= 1) {
//            return test;
//        }
//
//        List<Integer> left;
//        List<Integer> right;
//        int mid = (test.size() - 1) / 2;
//
//        List<List<Integer>> array = new ArrayList<>(test.stream()
//                .collect(Collectors.partitioningBy(s -> test.indexOf(s) > mid))
//                .values());
//        left = sort(array.get(0));
//        right = sort(array.get(1));
//
//        return merge(left, right);
//    }
//
//    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
//        List<Integer> result = new ArrayList<>();
//        int i = 0;
//        int j = 0;
//
//        while(i < left.size() && j < right.size()){
//            if(left.get(i) < right.get(j)){
//                result.add(left.get(i));
//                i++;
//            }else{
//                result.add(right.get(j));
//                j++;
//            }
//        }
//
//        if(i == left.size()){
//            while(j < right.size()){
//                result.add(right.get(j));
//                j++;
//            }
//        }else{
//            while(i < left.size()){
//                result.add(left.get(i));
//                i++;
//            }
//        }
//        return result;
//    }


    public static int quickSelect(int[] arr, int key, int left, int right){
        if(right - left <= 0){
            return arr[key];
        }
        int pivotIndex = partition(arr, left, right);
        if(key < pivotIndex){
            return quickSelect(arr, key, left, pivotIndex -1);
        }else if(key > pivotIndex){
            return quickSelect(arr, key, pivotIndex + 1, right);
        }else{
            return arr[pivotIndex];
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = right;
        int pivot = arr[pivotIndex]; // 오른쪽
        right--;
        while(true){
            while(arr[left] < pivot){
                left++;
            }
            while(arr[right] > pivot){
                right--;
                if(right <= 0){
                    break;
                }
            }
            if(left >= right){
                break;
            }else{
                swap(arr, left, right);
            }
        }
        swap(arr, left, pivotIndex);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

//    function quickselect(arr, kth, left, right) {
//        if (right - left <= 0) {
//            return arr[left];
//        }
//  const pivotIndex = partition(arr, left, right);
//        if (kth < pivotIndex) {
//            return quickselect(arr, kth, left, pivotIndex - 1);
//        } else if (kth > pivotIndex) {
//            return quickselect(arr, kth, pivotIndex + 1, right);
//        } else {
//            return arr[pivotIndex];
//        }
//    }
//    function partition(arr, left, right) {
//  const pivotIndex = right;
//  const pivot = arr[pivotIndex];
//        right -= 1;
//        while (true) {
//            while (arr[left] < pivot) {
//                left += 1;
//            }
//            while (arr[right] > pivot) {
//                right -= 1;
//            }
//            if (left >= right) {
//                break;
//            } else {
//                swap(arr, left, right);
//            }
//        }
//        swap(arr, left, pivotIndex);
//        return left;
//    }
//    // 순서를 바꾸는 함수
//    function swap(arr, left, right) {
//  const temp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = temp;
//    }

}
