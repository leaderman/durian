package com.miaoyurun.durian.aigc.deepseek.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaoyurun.durian.aigc.deepseek.model.Model;
import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionsResponse {
    private String id;
    private List<Choice> choices;
    private int created;
    private Model model;
    @JsonProperty("system_fingerprint")
    private String systemFingerprint;
    private Usage usage;
}
