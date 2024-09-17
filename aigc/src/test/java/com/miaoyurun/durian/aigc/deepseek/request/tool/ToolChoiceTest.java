package com.miaoyurun.durian.aigc.deepseek.request.tool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaoyurun.durian.aigc.deepseek.request.Function;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ToolChoiceTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testToolChoice() throws JsonProcessingException {
        ToolChoice chatCompletionToolChoice = new ChatCompletionToolChoice(ToolChoiceName.AUTO);
        log.info("chatCompletionToolChoice: {}", objectMapper.writeValueAsString(chatCompletionToolChoice));

        ToolChoice chatCompletionNamedToolChoice = new ChatCompletionNamedToolChoice(
                new FunctionTool(new Function("getWeather")));
        log.info("chatCompletionNamedToolChoice: {}", objectMapper.writeValueAsString(chatCompletionNamedToolChoice));
    }
}
