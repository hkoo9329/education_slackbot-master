package ac.knu.service;


import java.util.HashMap;

public class CommandProcessing {
    private int MAXMAPSIZE = 10;
    private HashMap<String, Friends> friends;

    public CommandProcessing() {
        friends = new HashMap<String, Friends>();
    }

    public String addFriend(String friendName, int friendAge, Friends.Sex friendSex) {
        if (isFriendsListFull()) {
            return "추가할수 있는 친구의 수가 최대입니다.";
        }
        else if(friendNameCheck(friendName)){
            return "이미 존재하는 이름입니다. 이름은 고유해야 합니다.";
        }
        else {
            Friends friend = new Friends(friendName, friendAge, friendSex);
            friends.put(friendName, friend);
            return "친구를 추가 했습니다.";
        }
    }

    public String removeFriend(String friendName) {
        if (!friendNameCheck(friendName)) {
            return "해당친구는 목록에 존재하지 않습니다.";
        } else {
            friends.remove(friendName);
            return "친구를 목록에서 삭제했습니다.";
        }
    }

    public String printFriendsList() {
        String printListString = "";
        if (isFriendsListEmpty()) {
            return "리스트에 친구가 존재하지 않습니다.";
        }
        for (String key : friends.keySet()) {
            printListString += friends.get(key).toString() + "\n";
        }
        return printListString;
    }

    public String findFriend(String friendName) {
        if (!friendNameCheck(friendName)) {
            return "해당친구는 목록에 존재하지 않습니다.";
        } else {
            return friends.get(friendName).toString();
        }
    }

    public boolean isFriendsListFull() {
        return friends.size() > MAXMAPSIZE;
    }

    public boolean isFriendsListEmpty(){
        return friends.size() <= 0;
    }

    public boolean friendNameCheck(String friendName){
        return friends.containsKey(friendName);
    }
}
