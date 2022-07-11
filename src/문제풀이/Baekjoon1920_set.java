package 문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon1920_set {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> n_set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            n_set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        int[] m_list = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            m_list[i] = Integer.parseInt(st.nextToken());
        }

        for (int target : m_list) {
            if(n_set.contains(target)){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
    }
}
