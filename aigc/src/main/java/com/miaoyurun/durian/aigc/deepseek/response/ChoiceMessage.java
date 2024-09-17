package com.miaoyurun.durian.aigc.deepseek.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaoyurun.durian.aigc.deepseek.entity.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChoiceMessage extends Message {
    @JsonProperty("tool_calls")
    private List<ToolCall> toolCalls;
}
