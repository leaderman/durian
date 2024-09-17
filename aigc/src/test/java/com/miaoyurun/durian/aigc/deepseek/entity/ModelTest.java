package com.miaoyurun.durian.aigc.deepseek.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ModelTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testModel() throws JsonProcessingException {
        Model chat = Model.CHAT;
        log.info("chat: {}", objectMapper.writeValueAsString(chat));

        Model coder = Model.CODER;
        log.info("coder: {}", objectMapper.writeValueAsString(coder));
    }
}
