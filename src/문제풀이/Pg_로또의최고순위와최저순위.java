package 문제풀이;

import java.util.Arrays;
import java.util.OptionalInt;

public class Pg_로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos = new int[6];
        int[] win_nums = new int[6];
        lottos[0] = 44;
        lottos[1] = 1;
        lottos[2] = 0;
        lottos[3] = 0;
        lottos[4] = 31;
        lottos[5] = 25;

        win_nums[0] = 31;
        win_nums[1] = 10;
        win_nums[2] = 45;
        win_nums[3] = 1;
        win_nums[4] = 6;
        win_nums[5] = 19;

        int[] result = solution(lottos, win_nums);
        for (int i : result) {
            System.out.println(i);
        }

    }
    public static int[] solution(int[] lottos, int[] win_nums){

        int collect_cnt = 0;
        for(int i = 0 ; i < win_nums.length; i++){
            int val = win_nums[i];
            OptionalInt first = Arrays.stream(lottos).filter(value -> val == value).findFirst();
            if (first.isPresent()) {
                collect_cnt++;
            }
        }
        int worst = checkRank(collect_cnt);

        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                collect_cnt++;
            }
        }
        int best = checkRank(collect_cnt);

        return new int[]{best,worst};
    }

    private static int checkRank(int cnt) {
      if(cnt <= 1){
          return 6;
      }else if(cnt ==2){
          return 5;
      }else if(cnt ==3){
          return 4;
      }else if(cnt ==4){
          return 3;
      }else if(cnt ==5){
          return 2;
      }else{
          return 1;
      }
    }
}
