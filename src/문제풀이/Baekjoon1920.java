package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] n_list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            n_list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n_list);

        int m = Integer.parseInt(br.readLine());
        int[] m_list = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            m_list[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < m_list.length; i++){
            int target = m_list[i];
            boolean target_chk = check(n_list, target,0,n-1);
            if(target_chk){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }

    private static boolean check(int[] n_list, int target, int low, int high) {
        if(low <= high){
            int mid = (low + high) / 2;
            if(target == n_list[mid]){
                return true;
            }else if(target < n_list[mid]){
                return check(n_list, target, 0, mid-1);
            }else{
                return check(n_list, target, mid+1, high);
            }
        }
        return false;
    }
}
