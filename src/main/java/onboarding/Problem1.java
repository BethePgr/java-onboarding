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
        if(!isBothAllRight(pobi,crong)) return -1;
        int pobiScore = listDecideMultiAndAdd(pobi);
        int crongScore = listDecideMultiAndAdd(crong);
        System.out.println("pobiScore " + pobiScore);
        System.out.println("crongScore " + crongScore);

        return comPareTwoInt(pobiScore,crongScore);
    }

    //리스트의 두 숫자가 연속인가
    private static boolean isContinuous(List<Integer> list) {
        return list.get(0) + 1 == list.get(1);
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
        return (num / 10) + (num % 10);
    }

    //숫자가 들어오면 각자리의 숫자의 곱을 구해주는 메서드
    private static int multipleNum(int num) {
        if (num >= 100) {
            return (num / 100) * ((num % 100) / 10) * (num % 10);
        }
        return (num / 10) * (num % 10);
    }

    //multipleNum과 addNum 둘 중에 어떠한 값이 더 큰가
    private static int decideMultiAndAdd(int num){
        return Math.max(addNum(num),multipleNum(num));
    }

    //리스트가 들어왔을 시 리스트이 첫 번째 값과 두 번째 값의 decideMultiAndAdd해주기
    private static int listDecideMultiAndAdd(List<Integer> list){
        return Math.max(decideMultiAndAdd(list.get(0)),decideMultiAndAdd(list.get(1)));
    }

    //oddAndEven && isBetweenOneAndFourHundred && isContinuous 세 조건을 만족하는가?
    private static boolean isAllRight(List<Integer> list){
        return oddAndEven(list) && isBetweenOneAndFourHundred(list) && isContinuous(list);
    }

    //두 명 다 isAllRight를 만족하는가?
    private static boolean isBothAllRight(List<Integer> list1, List<Integer> list2){
        return isAllRight(list1) && isAllRight(list2);
    }

    //숫자 두 개가 입력받아서 앞의 숫자가 더 크면 1, 뒤가 크면 2, 같으면 0을 리턴받는 메서드
    private static int comPareTwoInt(int num1, int num2){
        if(num1>num2) return 1;
        if(num1 < num2) return 2;
        return 0;
    }


}