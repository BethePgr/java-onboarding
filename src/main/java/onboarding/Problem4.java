package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    static Map<Integer,Integer> map = new HashMap<>();

    //A = 65 Z=90 M = 77  a = 97 z = 122 m= 109
    public static String solution(String word) {
        String answer = "";
        completeMap();
        return "";
    }

    //A는 Z로, a는 Z로 역순시켜주는 static map을 완성시키는 메서드를 만든다.
    private static void completeMap(){
        for(int i = 0;i<=25;i++){
            map.put(65+i,90-i);
            map.put(97+i,122-i);
        }
    }

    //들어온 숫자 하나를 map의 키라고 생각했을 때, 해당되는 value값을 Character형으로 가져오는 메서드
    private static Character mappingKeyAndValue(int num){
        int intNum = map.get(num);
        return (char)intNum;
    }

}
