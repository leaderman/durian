package com.miaoyurun.durian.aigc.deepseek.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Choice {
    @JsonProperty("finish_reason")
    private FinishReason finishReason;
    private int index;
    private Message message;
}
