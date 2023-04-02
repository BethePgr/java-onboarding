package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /*
     오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전,
     백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트
     배열에 담아 return 하도록 solution 메서드를 완성하
    | money | result |
| --- | --- |
| 50237	| [1, 0, 0, 0, 0, 2, 0, 3, 7] |
| 15000	| [0, 1, 1, 0, 0, 0, 0, 0, 0] |
     */

    static int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> list = repeatReturnQuoRemainder(money);
        return list;
    }

    //앞의 숫자가 들어오면 뒷 숫자로 나눈 몫과 나머지를 배열로 리턴한다.
    private static int[] returnQuoRemainder(int num1, int num2) {
        int[] arr = new int[2];
        arr[0] = num1 / num2;
        arr[1] = num1 % num2;
        return arr;
    }

    //for문을 통해 static int 배열 arr를 하나하나 returnQuoRemainder를 적용하고 list<Integer>을 반환함.
    //한 번 할때마다 returnQuoRemainder의 0번지는 list에 추가되고 1번지는 num으로 재할당해준다.
    private static List<Integer> repeatReturnQuoRemainder(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] ints = returnQuoRemainder(num, arr[i]);
            list.add(ints[0]);
            num = ints[1];
        }
        return list;
    }
}
