package ac.knu.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommandParsingService {

    private CommandProcessing commandProcessing;

    public CommandParsingService() {
        commandProcessing = new CommandProcessing();
    }

    public String parseCommand(String text) {


        try {
            text = text.replaceAll("<[^>]*>", "");
            StringTokenizer tokenizer = new StringTokenizer(text);
            String command = tokenizer.nextToken().toLowerCase();

            switch (command) {
                case "time":
                    SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초");
                    return format.format(new Date());
                case "add":
                    return commandProcessing.addFriend(tokenizer.nextToken(), Integer.valueOf(tokenizer.nextToken())
                            , Gender.valueOf(tokenizer.nextToken()));
                case "remove":
                    return commandProcessing.removeFriend(tokenizer.nextToken());
                case "list":
                    return commandProcessing.printFriendsList();
                case "find":
                    return commandProcessing.findFriend(tokenizer.nextToken());
                default:
                    return helpMessege();
            }
        } catch (NoSuchElementException e) {
            return "명령어 입력이 잘못되었습니다.";
        } catch (NumberFormatException e) {
            return "나이는 숫자로 입력해주십시오.";
        } catch (IllegalArgumentException e) {
            return "성별은 \"남\" 또는 \"여\"로 입력해주십시오.";
        }

    }

    private String helpMessege() {

        return "add : 친구를 추가합니다.\n"
                + "remove : 해당 이름의 친구를 목록에서 삭제합니다.\n"
                + "time : 현재 시간을 알려줍니다.\n"
                + "list : 현재 친구목록 전체를 보여 줍니다.\n"
                + "find : 해당 이름의 친구가 목록에 있으면 친구의 정보를 출력합니다.\n";
    }
}

