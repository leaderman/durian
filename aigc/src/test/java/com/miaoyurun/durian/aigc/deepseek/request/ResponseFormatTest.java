package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ResponseFormatTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testResponseFormat() throws JsonProcessingException {
        ResponseFormat text = new ResponseFormat(Type.TEXT);
        log.info("text: {}", objectMapper.writeValueAsString(text));

        ResponseFormat jsonObject = new ResponseFormat(Type.JSON_OBJECT);
        log.info("jsonObject: {}", objectMapper.writeValueAsString(jsonObject));
    }
}
