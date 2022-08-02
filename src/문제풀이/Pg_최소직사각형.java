package 문제풀이;

public class Pg_최소직사각형 {
    public static void main(String[] args) {
        int[][] test = new int[5][2];
        test[0][0] = 10;
        test[0][1] = 7;
        test[1][0] = 12;
        test[1][1] = 3;
        test[2][0] = 8;
        test[2][1] = 15;
        test[3][0] = 14;
        test[3][1] = 7;
        test[4][0] = 5;
        test[4][1] = 15;

        int solution = solution(test);
        System.out.println(solution);
    }
    public static int solution(int[][] sizes){
        int w = 0;
        int h = 0;
        for (int i = 0 ; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]){
                swap(i, sizes);
            }
        }
        for (int[] size : sizes) {
            if(w < size[0]){
                w = size[0];
            }
            if(h < size[1]){
                h = size[1];
            }
        }

        return w * h;
    }

    public static void swap(int index, int[][] sizes) {
        int temp = sizes[index][0];
        sizes[index][0] = sizes[index][1];
        sizes[index][1] = temp;
    }
}
