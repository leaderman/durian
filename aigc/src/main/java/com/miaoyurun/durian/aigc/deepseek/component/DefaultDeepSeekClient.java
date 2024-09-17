package com.miaoyurun.durian.aigc.deepseek.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miaoyurun.durian.aigc.deepseek.DeepSeekClient;
import com.miaoyurun.durian.aigc.deepseek.request.ChatCompletionsRequest;
import com.miaoyurun.durian.aigc.deepseek.response.ChatCompletionsResponse;
import com.miaoyurun.durian.aigc.exception.AigcException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class DefaultDeepSeekClient implements DeepSeekClient {
    private static final String BASE_URL = "https://api.deepseek.com";
    private static final String CHAT_COMPLETIONS = "/chat/completions";
    private static final String AUTHORIZATION_PREFIX = "Bearer ";

    private final WebClient webClient;
    private final String token;
    private final ObjectMapper objectMapper;

    @Autowired
    public DefaultDeepSeekClient(WebClient webClient, @Value("${durian.aigc.deepseek.token}") String token,
                                 ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.token = token;
        this.objectMapper = objectMapper;
    }

    @Override
    public ChatCompletionsResponse chatCompletions(ChatCompletionsRequest request) {
        request.setStream(false);

        String result = webClient.post()
                .uri(BASE_URL + CHAT_COMPLETIONS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_PREFIX + token)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class).block();
        log.debug("chatCompletions result: {}", result);

        try {
            return objectMapper.readValue(result, ChatCompletionsResponse.class);
        } catch (JsonProcessingException e) {
            throw new AigcException(e);
        }
    }

    @Override
    public Flux<String> chatCompletionsStream(ChatCompletionsRequest request) {
        request.setStream(true);

        return webClient.post()
                .uri(BASE_URL + CHAT_COMPLETIONS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_EVENT_STREAM_VALUE)
                .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_PREFIX + token)
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(String.class);
    }
}
