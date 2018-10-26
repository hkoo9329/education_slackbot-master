package ac.knu.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandProcessingTest {

    private CommandProcessing commandProcessing;

    @Before
    public void CommandProcessingBefore() {
        commandProcessing = new CommandProcessing();
    }

    @Test
    public void addFriend() {

    }

    @Test
    public void removeFriend_메소드_예외처리_테스트() {
        commandProcessing.addFriend("홍길동", 25, Gender.남);
        String result = commandProcessing.removeFriend("동이");
        Assert.assertTrue(result == "해당친구는 목록에 존재하지 않습니다.");
        result = commandProcessing.removeFriend("홍길동");
        assertTrue(result.equals("친구를 목록에서 삭제했습니다."));

    }

    @Test
    public void 리스트에_친구가_한명도_없을때_예외처리() {
        String result = commandProcessing.printFriendsList();
        assertTrue(result.equals("리스트에 친구가 존재하지 않습니다."));
    }


}