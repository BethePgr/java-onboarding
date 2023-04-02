package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return lists(forms);
    }

    private static List<String> lists(List<List<String>> forms){
        Set<String> set = new HashSet<>();
        for(int i = 0;i<forms.size();i++){
            String str = forms.get(i).get(1);
            for(int j = 0;j<str.length()-1;j++){
                String temp = str.substring(j,j+2);
                for(int k =0;k<forms.size();k++){
                    if(i==k) continue;
                    if(forms.get(k).get(1).contains(temp)){
                        set.add(forms.get(k).get(0));
                        set.add(forms.get(i).get(0));
                    }
                }
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList,(o1,o2)->o1.compareTo(o2));
        return arrayList;
    }

    public static void main(String[] args) {

        List<List<String>> forms = new ArrayList<>();
        for(int i = 0;i<10000;i++){
            List<String> temp = new ArrayList<>();
            temp.add("jm@email.com");
            temp.add("가나다라마바사아자차");
            forms.add(temp);
        }
        System.out.println(lists(forms));
    }

}
