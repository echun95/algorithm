package 문제풀이;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pg_성격유형검사 {
    static int[] choiceVal = new int[]{3,2,1,0,1,2,3};
    static Character[] type = new Character[]{'R','T','C','F','J','M','A','N'};
    public static void main(String[] args) {
        String[] survey = new String[]{"AN","CF","MJ","RT","NA"};
        int[] choices = new int[]{5,3,2,7,5};
        String mbti = solution(survey, choices);
        System.out.println(mbti);
    }


    public static String solution(String[] survey, int[] choices){
        int[] score = new int[8];
        String mbti = "";
        Map<Character, Integer> index = new HashMap<>();
        for(int i = 0; i < 8; i++){
            index.put(type[i],i);
        }

        for(int i = 0; i < survey.length; i++){
            char[] arr = survey[i].toCharArray();
            int choice = choices[i];

            switch (choice){
                case 1:
                    score[index.get(arr[0])] += 3;
                    break;
                case 2:
                    score[index.get(arr[0])] += 2;
                    break;
                case 3:
                    score[index.get(arr[0])] += 1;
                    break;
                case 4:
                    break;
                case 5:
                    score[index.get(arr[1])] += 1;
                    break;
                case 6:
                    score[index.get(arr[1])] += 2;
                    break;
                case 7:
                    score[index.get(arr[1])] += 3;
                    break;
            }
        }
        for(int i = 0; i < 8; i = i+2){
            if(score[i] == score[i+1]){
                if(type[i] < type[i+1]){
                    mbti += type[i];
                }else{
                    mbti += type[i+1];
                }
                continue;
            }
            if(score[i] > score[i+1]){
                mbti += type[i];
                continue;
            }else{
                mbti += type[i+1];
                continue;
            }
        }
        return mbti;
    }
}
