package onboarding;

import java.util.Stack;

/*
암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다.
예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.

"browoanoommnaon"
"browoannaon"
"browoaaon"
"browoon"
"brown"
brown
임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를
return 하도록 solution 메서드를 완성하라.
 */

// 하나씩 스택에 넣다가 peek값이 push값과 같다면 다를때까지 pop해준다.
public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        Character last = '1';
        while(index<=cryptogram.length()-1){
            if(stack.isEmpty() && last != cryptogram.charAt(index) ){
                stack.push(cryptogram.charAt(index++));
            }else if (stack.isEmpty() && last == cryptogram.charAt(index)){
                index++;
            }else{
                if(last == cryptogram.charAt(index)){
                    index++;
                }else{
                    if(stack.peek() == cryptogram.charAt(index)){
                        stack.pop();
                        last =  cryptogram.charAt(index);
                        index++;

                    }else{
                        stack.push(cryptogram.charAt(index++));
                    }
                }
            }
        }
        String answer = "";
        for(char x : stack) answer+=x;


        return answer;
    }




}
