package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return "";
    }

    //반복이 시작되는 인덱스랑 끝나는 인덱스(whenContinuousEnd로 구한 값)를 통해 그 사이의 값들을 빈 값으로
    //대체한다.
    private static String replaceString(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (checkStepByStep(cryptogram,i,i+1)) {
                int index = whenContinuousEnd(cryptogram, i) + 1;
                return new StringBuilder(cryptogram).replace(i, index, "").toString();
            }
        }
        return cryptogram;
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
