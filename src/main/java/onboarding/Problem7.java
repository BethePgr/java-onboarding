package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        return null;
    }

    //user와 직접적인 친구인 목록을 리턴하는 메서드
    private static List<String> friendsWithUser(String user,List<List<String>> friends){
        ArrayList<String> friendsWithUserList = new ArrayList<>();
        for(List<String> friend : friends){
            if(friend.contains(user)){
                addFriends(user, friendsWithUserList, friend);
            }
        }
        return friendsWithUserList;
    }

    //길이가 2인 리스트에서 user가 아닌 다른 한명의 이름을 리스트에 담는 메소드
    private static void addFriends(String user, ArrayList<String> friendsWithUserList, List<String> friend) {
        for(String str : friend){
            if(!str.equals(user)){
                friendsWithUserList.add(str);
            }
        }
    }



}
