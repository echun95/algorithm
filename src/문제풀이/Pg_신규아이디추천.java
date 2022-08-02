package 문제풀이;

public class Pg_신규아이디추천 {
    public static void main(String[] args) {
        String test = 	"123_.def";
        String result = solution(test);
        System.out.println(result);
    }

    private static String solution(String test) {

        //1단계 소문자 치환
        test = test.toLowerCase();

        //2단계 소문자, 숫자, -, _, .를 제외한 모든 문자 제거
        test = replaceSpecialChar(test);

        //3단계 마침표 2번이상 연속되면 하나로 치환
        test = replaceDot(test);

        //4단계 마침표가 처음 or 끝이면 삭제
        test = deleteDot(test);

        //5단계 빈 문자열이면 a를 대입
        test = ifStringNull(test);

        //6단계 길이가 16자 이상이면 15개까지 끊기
        test = limitLen15(test);

        //7단계 아이디의 길이가 2자 이하면 마지막 문자를 길이가 3이 될떄까지 반복
        test = vouch3Len(test);
        return test;
    }

    private static String vouch3Len(String test) {
        if(test.length() <= 2){
            while(test.length() < 3){
                if(test.length() == 0){
                    test +="a";
                    continue;
                }
                String substring = test.substring(test.length() - 1);
                test += substring;
            }
        }
        return test;
    }

    private static String limitLen15(String test) {
        if(test.length() >= 16){
            test = test.substring(0, 15);
            test = deleteDot(test);
        }
        return test;
    }

    private static String ifStringNull(String test) {
        if(test == null){
            test = "a";
        }
        return test;
    }

    private static String deleteDot(String test) {
        test = test.replaceAll("^\\.|\\.$", "");
        return test;
    }

    private static String replaceDot(String test) {
        test = test.replaceAll("\\.+", ".");
        return test;
    }

    private static String replaceSpecialChar(String test) {
        return test.replaceAll("[^a-z\\d-_.]", "");
    }
}
