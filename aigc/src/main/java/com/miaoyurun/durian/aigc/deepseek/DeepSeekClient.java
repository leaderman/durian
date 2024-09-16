package com.miaoyurun.durian.aigc.deepseek;

import com.miaoyurun.durian.aigc.deepseek.request.ChatCompletionsRequest;
import com.miaoyurun.durian.aigc.deepseek.response.ChatCompletionsResponse;

public interface DeepSeekClient {
    ChatCompletionsResponse chatCompletions(ChatCompletionsRequest request);
}
