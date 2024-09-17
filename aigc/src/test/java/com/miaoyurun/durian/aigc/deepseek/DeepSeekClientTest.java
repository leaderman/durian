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
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@Slf4j
public class DeepSeekClientTest {
    @Autowired
    private DeepSeekClient deepSeekClient;

    @Test
    public void testChatCompletions() {
        ChatCompletionsRequest request = new ChatCompletionsRequest();

        List<Message> messages = List.of(
                new SystemMessage("你是一个资深的 Java 技术专家，可以使用中文回答我的问题，必要时也可以使用英文。"),
                new UserMessage("请简要说明使用 SpringBoot 开发 Java 应用程序的优势是什么？"));
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

    @Test
    public void testChatCompletionsStream() throws InterruptedException {
        ChatCompletionsRequest request = new ChatCompletionsRequest();

        List<Message> messages = List.of(
                new SystemMessage("你是一个资深的 Java 技术专家，可以使用中文回答我的问题，必要时也可以使用英文。"),
                new UserMessage("请简要说明使用 SpringBoot 开发 Java 应用程序的优势是什么？"));
        request.setMessages(messages);

        request.setModel(Model.CHAT);

        request.setStream(true);

        Flux<String> stream = deepSeekClient.chatCompletionsStream(request);

        CountDownLatch latch = new CountDownLatch(1);

        stream.subscribe(message -> log.info("stream message: {}", message),
                error -> log.error("stream error", error),
                () -> {
                    log.info("stream completed");
                    latch.countDown();
                });

        latch.await();
    }
}
