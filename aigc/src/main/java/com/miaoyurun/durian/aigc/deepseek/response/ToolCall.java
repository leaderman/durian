package com.miaoyurun.durian.aigc.deepseek.response;

import lombok.Data;

@Data
public class ToolCall {
    private String id;
    private ToolCallType type;
    private ToolCallFunction function;
}
