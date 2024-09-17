package com.miaoyurun.durian.aigc.deepseek.request.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MessageTest {
    @Test
    public void testMessage() {
        Message system = new SystemMessage("system", "I'm a system message");
        log.info("System name: {}", system.getName());
        log.info("System role: {}", system.getRole());
        log.info("System content: {}", system.getContent());

        Message user = new UserMessage("user", "I'm a user message");
        log.info("User name: {}", user.getName());
        log.info("User role: {}", user.getRole());
        log.info("User content: {}", user.getContent());

        Message assistant = new AssistantMessage("assistant", "I'm an assistant message");
        log.info("Assistant name: {}", assistant.getName());
        log.info("Assistant role: {}", assistant.getRole());
        log.info("Assistant content: {}", assistant.getContent());
    }
}
