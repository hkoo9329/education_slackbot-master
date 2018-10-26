package ac.knu.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandProcessingTest {

    private CommandProcessing commandProcessing;

    @Before
    public void CommandProcessingBefore() {
        commandProcessing = new CommandProcessing();
    }

    @Test
    public void addFriend_메소드_친구추가최대수_예외처리_테스트() {
        for(int i=0;i<10;i++) {
            commandProcessing.addFriend("테스트"+i, 25, Gender.valueOf("남"));
        }
        String result = commandProcessing.addFriend("테스트10", 25, Gender.valueOf("남"));
        assertEquals("추가할수 있는 친구의 수가 최대입니다.", result);
    }
    @Test
    public void addFriend_메소드_동일친구이름_예외처리_테스트(){
        for(int i=0;i<10;i++) {
            commandProcessing.addFriend("테스트"+i, 25, Gender.valueOf("남"));
        }
        String result = commandProcessing.addFriend("테스트0", 25, Gender.valueOf("남"));
        assertTrue(result.equals("이미 존재하는 이름입니다. 이름은 고유해야 합니다."));
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