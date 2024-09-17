package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.miaoyurun.durian.aigc.deepseek.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MessageTest {
    @Test
    public void testMessage() {
        Message system = new SystemMessage("system", "I'm a system message");
        log.info("system: {}", system);

        system = new SystemMessage("I'm another system message");
        log.info("system: {}", system);

        Message user = new UserMessage("user", "I'm a user message");
        log.info("user: {}", user);

        user = new UserMessage("I'm another user message");
        log.info("user: {}", user);

        Message assistant = new AssistantMessage("assistant", "I'm an assistant message");
        log.info("assistant: {}", assistant);

        assistant = new AssistantMessage("I'm another assistant message");
        log.info("assistant: {}", assistant);
    }
}
