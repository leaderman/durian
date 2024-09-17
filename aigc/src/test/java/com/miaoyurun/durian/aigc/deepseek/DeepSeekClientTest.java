package com.miaoyurun.durian.aigc.deepseek;

import com.miaoyurun.durian.aigc.deepseek.entity.Model;
import com.miaoyurun.durian.aigc.deepseek.request.ChatCompletionsRequest;
import com.miaoyurun.durian.aigc.deepseek.request.message.Message;
import com.miaoyurun.durian.aigc.deepseek.request.message.SystemMessage;
import com.miaoyurun.durian.aigc.deepseek.request.message.UserMessage;
import com.miaoyurun.durian.aigc.deepseek.response.ChatCompletionsResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class DeepSeekClientTest {
    @Autowired
    private DeepSeekClient deepSeekClient;

    @Test
    public void testChatCompletions() {
        ChatCompletionsRequest request = new ChatCompletionsRequest();

        List<Message> messages = List.of(
                new SystemMessage("You are a helpful assistant"),
                new UserMessage("Hi"));
        request.setMessages(messages);

        request.setModel(Model.CHAT);

        ChatCompletionsResponse response = deepSeekClient.chatCompletions(request);

        log.info("id: {}", response.getId());

        response.getChoices().forEach(choice -> {
            log.info("index: {}", choice.getIndex());
            log.info("message: {}", choice.getMessage());
            log.info("finishReason: {}", choice.getFinishReason());
        });

        log.info("created: {}", response.getCreated());
        log.info("model: {}", response.getModel());
        log.info("systemFingerprint: {}", response.getSystemFingerprint());
        log.info("usage: {}", response.getUsage());
    }
}
