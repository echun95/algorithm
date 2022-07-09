package 문제풀이;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1966 {
    static class Item{
        private int index;
        private int importance;

        public Item(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cnt = Integer.parseInt(br.readLine()); // 총 테스트 수

        for(int i=0; i < test_cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int count = 0;

            st = new StringTokenizer(br.readLine(), " ");
            Queue<Item> q = new LinkedList<>();
            for(int j=0; j < n; j++){
                q.add(new Item(j,Integer.parseInt(st.nextToken())));
            }

            while(!q.isEmpty()){
                int max = q.stream().mapToInt(item -> item.importance)
                        .max()
                        .getAsInt();
                Item first = q.peek();
                if(first.importance == max){
                    count++;
                    if(first.index == target){
                        System.out.println(count);
                        break;
                    }
                    q.poll();
                }else{
                    q.add(q.poll());
                }
            }
        }
    }
}
