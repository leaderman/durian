package com.miaoyurun.durian.aigc.deepseek.request.tool;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChatCompletionToolChoice extends ToolChoice {
    @JsonValue
    private ToolChoiceName name;
}
