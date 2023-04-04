package onboarding;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> userNameList = createUserNameList(forms);
        String collectedName = collectUserName(userNameList);

        return null;
    }

    //forms의 이름 하나하나를 list에 담아 리턴하는 메서드
    private static List<String> createUserNameList(List<List<String>> forms){
        ArrayList<String> list = new ArrayList<>();
        for(List<String> form : forms){
            list.add(form.get(1));
        }
        return list;
    }

    //닉네임이 담긴 리스트들을 ,로 join하기
    private static String collectUserName(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(String x : list){
            stringBuilder.append(x).append(",");
        }
        return stringBuilder.toString();
    }
}
