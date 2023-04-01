package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
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

}
