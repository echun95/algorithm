package 문제풀이;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pg_오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = solution(record);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String[] solution(String[] record) {
        String[] answer;
        Map<String, String> nickMap = new HashMap<>();
        List<User> logs = new ArrayList<>();

        for (String action : record) {
            String[] split = action.split(" ");
            User user = new User();
            if(!split[0].equals("Change")){
                user.setState(split[0]);
                user.setId(split[1]);
                logs.add(user);
            }
            if (split[0].equals("Enter")) {
                nickMap.put(split[1], split[2]);
            } else if (split[0].equals("Change")) {
                nickMap.put(split[1], split[2]);
            }
        }
        answer = new String[logs.size()];
        for(int i = 0; i < logs.size(); i++){
            User log = logs.get(i);
            if(log.getState().equals("Enter")){
                answer[i] = nickMap.get(log.getId()) + "님이 들어왔습니다.";
            }else{
                answer[i] = nickMap.get(log.getId()) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    static class User {
        private String state;
        private String id;
        private String nick;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }
    }
}
