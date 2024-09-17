package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaoyurun.durian.aigc.deepseek.entity.Model;
import com.miaoyurun.durian.aigc.deepseek.request.message.Message;
import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionsRequest {
    private List<Message> messages;
    private Model model;
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty = 0.0;
    @JsonProperty("max_tokens")
    private Integer maxTokens = 2048;
    @JsonProperty("presence_penalty")
    private Double presencePenalty = 0.0;
    @JsonProperty("response_format")
    private ResponseFormat responseFormat = new ResponseFormat(Type.TEXT);
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> stop;
    private Boolean stream = false;
    @JsonProperty("stream_options")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StreamOptions streamOptions;
    private Double temperature = 1.0;
    @JsonProperty("top_p")
    private Double topP = 1.0;
    private Boolean logprobs;
    @JsonProperty("top_logprobs")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer topLogprobs;
}
