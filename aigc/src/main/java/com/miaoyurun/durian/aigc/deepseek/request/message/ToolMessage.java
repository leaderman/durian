package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miaoyurun.durian.aigc.deepseek.entity.Message;
import com.miaoyurun.durian.aigc.deepseek.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ToolMessage extends Message {
    @JsonProperty("tool_call_id")
    private String toolCallId;

    public ToolMessage(String toolCallId, String content) {
        super(Role.TOOL, content);
        this.toolCallId = toolCallId;
    }
}
