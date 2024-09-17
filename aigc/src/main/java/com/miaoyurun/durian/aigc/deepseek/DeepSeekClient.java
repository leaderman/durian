package com.miaoyurun.durian.aigc.deepseek;

import com.miaoyurun.durian.aigc.deepseek.request.ChatCompletionsRequest;
import com.miaoyurun.durian.aigc.deepseek.response.ChatCompletionsResponse;
import reactor.core.publisher.Flux;

public interface DeepSeekClient {
    ChatCompletionsResponse chatCompletions(ChatCompletionsRequest request);

    Flux<String> chatCompletionsStream(ChatCompletionsRequest request);
}
