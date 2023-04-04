package onboarding;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    //긴 String에서 ,가 포함되지 않은 연속된 두 글자들을 list에 담는다.
    private static List<String> getListOfTwoLetters(String str){
        ArrayList<String> list = new ArrayList<>();
        String [] strArray = str.split("");
        for(int i = 0;i< strArray.length-1;i++){
            list.add(strArray[i] + strArray[i+1]);
        }
        return list.stream().filter(x -> !x.contains(",")).sorted().collect(Collectors.toList());
    }
}
