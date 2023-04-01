package onboarding;

import java.util.List;


/*
책을 임의로 펼친다.
왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
*/
class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    //리스트의 두 숫자가 연속인가
    private static boolean isContinuous(List<Integer> list) {
        return list.get(0) + 1 == list.get(0);
    }

    //리스트의 두 숫자가 1과 400사이인가
    private static boolean isBetweenOneAndFourHundred(List<Integer> list) {
        return (list.get(0) >= 1) && (list.get(1) <= 400);
    }

    //왼쪽이 홀수이고 오른쪽이 짝수가 맞는가
    private static boolean oddAndEven(List<Integer> list) {
        return (list.get(0) % 2 == 1) && (list.get(1) % 2 == 0);
    }

    //숫자가 들어오면 각자리의 숫자의 합을 구해주는 메서드
    private static int addNum(int num) {
        if (num >= 100) {
            return num / 100 + (num % 100) / 10 + num % 10;
        }
        return num / 10 + num % 10;
    }

    //숫자가 들어오면 각자리의 숫자의 곱을 구해주는 메서드
    private static int multipleNum(int num) {
        if (num >= 100) {
            return num / 100 * (num % 100) / 10 * num % 10;
        }
        return num / 10 * num % 10;
    }

    //oddAndEven && isBetweenOneAndFourHundred && isContinuous 세 조건을 만족하는가?
    private static boolean isAllRight(List<Integer> list){
        return oddAndEven(list) && isBetweenOneAndFourHundred(list) && isContinuous(list);
    }

    //두 명 다 isAllRight를 만족하는가?
    private static boolean isBothAllRight(List<Integer> list1, List<Integer> list2){
        return isAllRight(list1) && isAllRight(list2);
    }

}