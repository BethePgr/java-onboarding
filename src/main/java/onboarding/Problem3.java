package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return count369FromOneToNum(number);
    }

    //해당 숫자가 3,6,9에 해당하는가?
    private static boolean isNum369(int num){
        return (num == 3 || num == 6 || num == 9);
    }

    //숫자 입력 받을 시 각 자리의 숫자를 isNum369를 통해 true일때의 count합을 리턴한다.
    private static int countOneByOne(int num){
        int count = 0;
        while(num >=10){
            if(isNum369(num%10)){
                count++;
            }
            num=num/10;
        }
        if(isNum369(num)) count++;
        return count;
    }

    //1부터 입력받는 숫자까지 countOneByOne을 통해 이제까지 나온 3,6,9의 총 개수를 구한다.
    private static int count369FromOneToNum(int num){
        int count = 0;
        for(int i = 1;i<=num;i++){
            count += countOneByOne(i);
        }
        return count;
    }

}
