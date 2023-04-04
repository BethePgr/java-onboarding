package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> userNameList = createUserNameList(forms);
        String collectedName = collectUserName(userNameList);
        List<String> listOfTwoLetters = getListOfTwoLetters(collectedName);
        Set<String> set = setTwoLetters(listOfTwoLetters);
        List<String> answers = repeatAddList(forms, set);
        Collections.sort(answers);
        return answers;
    }

    //forms의 이름 하나하나를 list에 담아 리턴하는 메서드
    private static List<String> createUserNameList(List<List<String>> forms) {
        ArrayList<String> list = new ArrayList<>();
        for (List<String> form : forms) {
            list.add(form.get(1));
        }
        return list;
    }

    //닉네임이 담긴 리스트들을 ,로 join하기
    private static String collectUserName(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String x : list) {
            stringBuilder.append(x).append(",");
        }
        return stringBuilder.toString();
    }

    //긴 String에서 ,가 포함되지 않은 연속된 두 글자들을 list에 담는다.
    private static List<String> getListOfTwoLetters(String str) {
        ArrayList<String> list = new ArrayList<>();
        String[] strArray = str.split("");
        for (int i = 0; i < strArray.length - 1; i++) {
            list.add(strArray[i] + strArray[i + 1]);
        }
        return list.stream().filter(x -> !x.contains(",")).sorted().collect(Collectors.toList());
    }

    //addNameSet을 list안의 모든 두 글자들에게 적용시키는 메서드
    private static Set<String> setTwoLetters(List<String> list) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < list.size() - 1; i++) {
            addNameSet(set, list.get(i), list.get(i + 1));
        }
        return set;
    }

    //현재의 인덱스랑 다음 인덱스의 값이 같다면 set에 현재 인덱스의 값을 넣어준다.
    private static void addNameSet(Set<String> set, String str1, String str2) {
        if (str1.equals(str2)) {
            set.add(str1);
        }
    }

    //forms의 모든 인자를 순회해주게 하는 메서드
    private static List<String> repeatAddList(List<List<String>> forms, Set<String> set) {
        ArrayList<String> list = new ArrayList<>();
        for (List<String> form : forms) {
            addList(list, form, set);
        }
        return list;
    }

    //forms의 한 인덱스가 set의 모든 인자를 확인해주는 메서드
    private static void addList(List<String> list, List<String> form, Set<String> set) {
        for (String nameSet : set) {
            checkContains(list, form, nameSet);
        }
    }

    //set의 한 인덱스가 forms의 한 인덱스에 포함되어있다면 list에 이메일을 추가하는 메서드
    private static void checkContains(List<String> list, List<String> form, String name) {
        if (form.get(1).contains(name)) {
            list.add(form.get(0));
        }
    }

}
