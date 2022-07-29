package 문제풀이;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Pg_신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = new String[4];
        String[] report = new String[5];
        id_list[0] = "muzi";
        id_list[1] = "frodo";
        id_list[2] = "apeach";
        id_list[3] = "neo";

        report[0] = "muzi frodo";
//        report[0] = "muzi frodo";
        report[1] = "apeach frodo";
        report[2] = "frodo neo";
        report[3] = "muzi neo";
        report[4] = "apeach muzi";

        int k = 2;
        solution(id_list, report, k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        //id_list = 사용자 아이디
        //report = 신고 당한 사용자 -> 사용자id 신고한id 형태의 문자열
        //k = 신고 횟수
        int[] answer = {};
        Map<String, String> report_map = new HashMap<>();
        Map<String, Integer> count_map = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            count_map.put(id_list[i], 0);
        }

        for(int i = 0; i < report.length; i++){
            String[] split = report[i].split(" ");
            report_map.put(report[i], split[1]);
        }
        for (String key : report_map.keySet()) {
            Integer cnt = count_map.get(report_map.get(key));
            count_map.put(report_map.get(key), cnt++);
        }
            System.out.println(report_map);
            System.out.println(count_map);

        return answer;
    }
}
