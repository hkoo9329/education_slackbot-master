package ac.knu.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommandParsingService {

    private List<String> commandList = new ArrayList<>();
    private HashMap<String, Friends> hashMap = new HashMap<String, Friends>();
    private CommandProcessing commandProcessing = new CommandProcessing();
    public CommandParsingService() {
        commandList.add("time");
        commandList.add("add");
        commandList.add("remove");
        commandList.add("list");
        commandList.add("find");
    }

    public String parseCommand(String text) {
        try {
            String result = "";
            text = text.replaceAll("<[^>]*>", "");
            StringTokenizer tokenizer = new StringTokenizer(text);
            String command = tokenizer.nextToken();
            String friendName;
            int friendAge;
            Friends.Sex sex;

            if (command.equalsIgnoreCase("time")) {
                return "Current time is : " + new Date();

            } else if (command.equalsIgnoreCase("add")) {
                friendName = tokenizer.nextToken();
                friendAge = Integer.valueOf(tokenizer.nextToken());
                sex = Friends.Sex.valueOf(tokenizer.nextToken());
                return commandProcessing.addFriend(friendName, friendAge, sex);

            } else if (command.equalsIgnoreCase("remove")) {
                friendName = tokenizer.nextToken();
                return commandProcessing.removeFriend(friendName);

            } else if (command.equalsIgnoreCase("list")) {
                return commandProcessing.printFriendsList();

            } else if (command.equalsIgnoreCase("find")) {
                friendName = tokenizer.nextToken();
                return commandProcessing.findFriend(friendName);

            } else {
                return helpMessege();
            }
        }catch (NoSuchElementException e){
            return "명령어 입력이 잘못되었습니다.";
        }
        catch (NumberFormatException e){
            return "나이는 숫자로 입력해주십시오.";
        }
        catch (IllegalArgumentException e){
            return "성별은 \"남\" 또는 \"여\"로 입력해주십시오.";
        }

    }

    private String helpMessege(){

        return "add : 친구를 추가합니다.\n"
                +"remove : 해당 이름의 친구를 목록에서 삭제합니다.\n"
                +"time : 현재 시간을 알려줍니다.\n"
                +"list : 현재 친구목록 전체를 보여 줍니다.\n"
                +"find : 해당 이름의 친구가 목록에 있으면 친구의 정보를 출력합니다.\n";
    }
}

