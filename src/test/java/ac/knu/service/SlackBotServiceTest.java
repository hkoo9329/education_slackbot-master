package ac.knu.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.StringTokenizer;

@Slf4j
public class SlackBotServiceTest {

    private SlackBotService slackBotService;

    @Before
    public void itit() {
        this.slackBotService = new SlackBotService();
    }

    @Test
    public void 스트링버퍼테스트() {
        String text = "<sssss> add 이름 나이 성별";
        text = text.replaceAll("<[^>]*>", "");
        StringTokenizer stringTokenizer = new StringTokenizer(text);
        while (stringTokenizer.hasMoreTokens()) {
            log.info(stringTokenizer.nextToken());
        }
    }

    @Test
    public void init() {
    }
}