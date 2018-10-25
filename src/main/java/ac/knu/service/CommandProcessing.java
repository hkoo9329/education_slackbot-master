package ac.knu.service;


import java.util.HashMap;

public class CommandProcessing {
    private int MAXMAPSIZE = 10;
    private HashMap<String, Friends> friends;

    public CommandProcessing() {
        friends = new HashMap<String, Friends>();
    }

    public String addFriend(String friendName, int friendAge, Friends.Sex friendSex) {
        if (friends.size() > MAXMAPSIZE)
            return "추가할수 있는 친구의 수가 최대입니다.";
        else {
            Friends friend = new Friends(friendName, friendAge, friendSex);
            friends.put(friendName, friend);
            return "친구를 추가 했습니다.";
        }
    }

    public String removeFriend(String friendName) {
        if (!friends.containsKey(friendName)) {
            return "해당친구는 목록에 존재하지 않습니다.";
        } else {
            friends.remove(friendName);
            return "친구를 목록에서 삭제했습니다.";
        }
    }

    public String printFriendsList() {
        String printListString = "";
        if (friends.size() <= 0) {
            return "리스트에 친구가 존재하지 않습니다.";
        }
        for (String key : friends.keySet()) {
            printListString += friends.get(key).toString() + "\n";
        }
        return printListString;
    }

    public String findFriend(String friendName) {
        if (!friends.containsKey(friendName)) {
            return "해당친구는 목록에 존재하지 않습니다.";
        } else {
            return friends.get(friendName).toString();
        }
    }
}
