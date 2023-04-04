package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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

    //friends배열이 들어올때, new HashMap을 만들어 friendsWithUser를 통해 얻은 리스트와 겹치는 두 아이디를 키로 가진 value를 10 증가시킨다.
    private static Map<String,Integer> friendsScoreMap(List<List<String>> friends, List<String> friendsWithUser,String user){
        HashMap<String, Integer> friendsScoreMap = new HashMap<>();
        for(List<String> friend : friends){
            if(friend.contains(user)) {
                continue;
            }
            for(String stringFriend : friendsWithUser){
                if(friend.contains(stringFriend)){
                    friendsScoreAddMap(friendsScoreMap,friend);
                }
            }
        }
        return friendsScoreMap;
    }
    //value 10을 증가시켜주는 직접적인 메서드
    private static void friendsScoreAddMap(Map<String,Integer> friendsScoreMap,List<String> friend) {
        for (String userFriend : friend) {
            friendsScoreMap.put(userFriend,friendsScoreMap.getOrDefault(userFriend, 0) + 10);
        }
    }

    //visitor 배열 값 하나하나를 key로 갖는 map의 value를 1씩 증가시켜주는 메서드
    private static void visitorsAddOnePoint(Map<String,Integer> friendsScoreMap,List<String> visitors){
        for(String visitor : visitors){
            friendsScoreMap.put(visitor,friendsScoreMap.getOrDefault(visitor,0) + 1);
        }
    }


}
