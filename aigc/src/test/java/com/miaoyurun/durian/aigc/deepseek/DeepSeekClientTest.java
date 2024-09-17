package com.miaoyurun.durian.aigc.deepseek;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaoyurun.durian.aigc.deepseek.entity.Model;
import com.miaoyurun.durian.aigc.deepseek.request.ChatCompletionsRequest;
import com.miaoyurun.durian.aigc.deepseek.request.Function;
import com.miaoyurun.durian.aigc.deepseek.request.JsonType;
import com.miaoyurun.durian.aigc.deepseek.request.Parameter;
import com.miaoyurun.durian.aigc.deepseek.entity.Message;
import com.miaoyurun.durian.aigc.deepseek.request.message.SystemMessage;
import com.miaoyurun.durian.aigc.deepseek.request.message.ToolMessage;
import com.miaoyurun.durian.aigc.deepseek.request.message.UserMessage;
import com.miaoyurun.durian.aigc.deepseek.request.tool.ChatCompletionToolChoice;
import com.miaoyurun.durian.aigc.deepseek.request.tool.FunctionTool;
import com.miaoyurun.durian.aigc.deepseek.request.tool.Tool;
import com.miaoyurun.durian.aigc.deepseek.request.tool.ToolChoiceName;
import com.miaoyurun.durian.aigc.deepseek.response.ChatCompletionsResponse;
import com.miaoyurun.durian.aigc.deepseek.response.Choice;
import com.miaoyurun.durian.aigc.deepseek.response.ChoiceMessage;
import com.miaoyurun.durian.aigc.deepseek.response.FinishReason;
import com.miaoyurun.durian.aigc.deepseek.response.ToolCall;
import com.miaoyurun.durian.aigc.deepseek.response.ToolCallFunction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@Slf4j
public class DeepSeekClientTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeepSeekClient deepSeekClient;

    @Test
    public void testChatCompletions() {
        ChatCompletionsRequest request = new ChatCompletionsRequest();

        List<Message> messages = List.of(
                new SystemMessage("你是一个资深的 Java 技术专家，可以使用中文回答我的问题，必要时也可以使用英文。"),
                new UserMessage("你是谁？"));
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

    @Test
    public void testFunctionCalling() throws JsonProcessingException {
        ChatCompletionsRequest request = new ChatCompletionsRequest();

        List<Tool> tools = List.of(
                new FunctionTool(
                        new Function("getWeather", "获取城市天气情况",
                                List.of(new Parameter("city", "城市名称", JsonType.STRING, true))))
        );
        request.setTools(tools);

        request.setToolChoice(new ChatCompletionToolChoice(ToolChoiceName.AUTO));

        List<Message> messages = new ArrayList<>();
        messages.add(new SystemMessage("你是一个天气查询机器人。"));
        messages.add(new UserMessage("天津的天气怎么样？"));

        request.setMessages(messages);

        request.setModel(Model.CHAT);

        log.info("request: {}", objectMapper.writeValueAsString(request));

        ChatCompletionsResponse response = deepSeekClient.chatCompletions(request);

        log.info("id: {}", response.getId());

        response.getChoices().forEach(choice -> {
            log.info("index: {}", choice.getIndex());
            log.info("message: {}", choice.getMessage());
            log.info("finishReason: {}", choice.getFinishReason());
        });

        Choice choice = response.getChoices().get(0);
        if (choice.getFinishReason() != FinishReason.TOOL_CALLS) {
            return;
        }

        ChoiceMessage choiceMessage = choice.getMessage();

        ToolCall toolCall = choiceMessage.getToolCalls().get(0);
        log.info("toolCall id: {}", toolCall.getId());

        ToolCallFunction function = toolCall.getFunction();
        log.info("function name: {}", function.getName());
        log.info("function arguments: {}", function.getArguments());

        // call
        messages.add(choiceMessage);
        // call result
        messages.add(new ToolMessage(toolCall.getId(), "天津的天气：轻风微拂，温度适宜，适合骑行。注意：请直接回复，不要有任何修改"));

        request.setMessages(messages);

        log.info("request: {}", objectMapper.writeValueAsString(request));

        response = deepSeekClient.chatCompletions(request);

        log.info("id: {}", response.getId());

        response.getChoices().forEach(c -> {
            log.info("index: {}", c.getIndex());
            log.info("message: {}", c.getMessage());
            log.info("finishReason: {}", c.getFinishReason());
        });
    }
}
