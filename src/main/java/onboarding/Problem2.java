package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return "";
    }

    //cryptogram의 i번째 인자와 i+1번째 인자의 값이 같은지 확인해주는 메서드
    private static boolean checkStepByStep(String cryptogram, int one, int two) {
        return cryptogram.charAt(one) == cryptogram.charAt(two);
    }

    //반복하는 문자열이 몇 번째 인덱스에서 끝나는지 알려주는 메서드
    private static int whenContinuousEnd(String cryptogram, int index) {
        int endIndex = index;
        for (int i = index; i < cryptogram.length() - 1; i++) {
            if (checkStepByStep(cryptogram, i, i + 1)) {
                endIndex++;
            }
            if (!checkStepByStep(cryptogram, i, i + 1)) {
                return endIndex;
            }
        }
        return cryptogram.length() - 1;
    }

}
