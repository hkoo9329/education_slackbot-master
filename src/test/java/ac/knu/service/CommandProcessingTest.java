package ac.knu.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@Slf4j
public class CommandProcessingTest {

    private CommandProcessing commandProcessing;
    @Before
    public void CommandProcessingBefore(){
        commandProcessing = new CommandProcessing();
    }
    @Test
    public void addFriend() {
        commandProcessing.addFriend("이주혁", 25, Friends.Sex.valueOf("남"));
    }

    @Test
    public void removeFriend_메소드_예외처리_테스트() {
        Friends friends = new Friends("이주혁", 25, Friends.Sex.남);
        commandProcessing.friends.put("이주혁", friends);
        String result = commandProcessing.removeFriend("학");
        Assert.assertTrue(result == "해당친구는 목록에 존재하지 않습니다.");
        result = commandProcessing.removeFriend("이주혁");
        log.info(result);
        assertTrue(result =="친구를 목록에서 삭제했습니다.");

    }


}