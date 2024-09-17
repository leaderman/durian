package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaoyurun.durian.aigc.deepseek.entity.Model;
import com.miaoyurun.durian.aigc.deepseek.entity.Message;
import com.miaoyurun.durian.aigc.deepseek.request.tool.Tool;
import com.miaoyurun.durian.aigc.deepseek.request.tool.ToolChoice;
import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionsRequest {
    private List<Message> messages;
    private Model model;
    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty = 0.0;
    @JsonProperty("max_tokens")
    private Integer maxTokens = 4096;
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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Tool> tools;
    @JsonProperty("tool_choice")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ToolChoice toolChoice;
}
