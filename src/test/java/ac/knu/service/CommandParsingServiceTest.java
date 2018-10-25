package ac.knu.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class CommandParsingServiceTest {

    CommandParsingService commandParsingService;

    @Before
    public void CommandParsingServiceBefore() {
        commandParsingService = new CommandParsingService();
    }

    @Test
    public void 현재시간_출력_포멧확인() {
        String result = commandParsingService.parseCommand("time");
        log.info(result);
    }

    @Test
    public void StringTokenizer_noSuchElementException_check() {
        String result = commandParsingService.parseCommand("add 사람");
        Assert.assertTrue(result == "명령어 입력이 잘못되었습니다.");
    }

    @Test
    public void 명령어_입력_오류_나이_예외처리테스트() {
        String result = commandParsingService.parseCommand("add 이주혁 ss 남");
        Assert.assertTrue(result == "나이는 숫자로 입력해주십시오.");
    }

    @Test
    public void 명령어_입력_오류_성별_예외처리테스트() {
        String result = commandParsingService.parseCommand("add 이주혁 25 인");
        log.info(result);
        Assert.assertTrue(result == "성별은 \"남\" 또는 \"여\"로 입력해주십시오.");

    }
}



