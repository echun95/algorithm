package 문제풀이;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1931 {

    static class Reservation{
        private int start;
        private int end;

        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        List<Reservation> test = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Reservation reservation = new Reservation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            test.add(reservation);
        }
        test.sort((o1, o2) -> {
            if(o1.end == o2.end){
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int count = 0;
        int end_time = 0;

        for(int i = 0; i < test.size(); i++){
            if(end_time <= test.get(i).start){
                end_time = test.get(i).end;
                count++;
            }
        }
        System.out.println(count);
    }
}
