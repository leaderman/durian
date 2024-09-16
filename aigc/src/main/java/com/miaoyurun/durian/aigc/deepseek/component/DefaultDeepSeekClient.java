package com.miaoyurun.durian.aigc.deepseek.component;

import com.miaoyurun.durian.aigc.deepseek.DeepSeekClient;
import com.miaoyurun.durian.aigc.deepseek.request.ChatCompletionsRequest;
import com.miaoyurun.durian.aigc.deepseek.response.ChatCompletionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DefaultDeepSeekClient implements DeepSeekClient {
    private static final String BASE_URL = "https://api.deepseek.com";
    private static final String CHAT_COMPLETIONS = "/chat/completions";
    private static final String AUTHORIZATION_PREFIX = "Bearer ";

    private final WebClient webClient;
    private final String token;

    @Autowired
    public DefaultDeepSeekClient(WebClient webClient, @Value("${durian.aigc.deepseek.token}") String token) {
        this.webClient = webClient;
        this.token = token;
    }

    @Override
    public ChatCompletionsResponse chatCompletions(ChatCompletionsRequest request) {
        return webClient.post()
                .uri(BASE_URL + CHAT_COMPLETIONS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_PREFIX + token)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatCompletionsResponse.class).block();
    }
}
