package com.miaoyurun.durian.aigc.deepseek.response;

import lombok.Data;

@Data
public class ToolCallFunction {
    private String name;
    private String arguments;
}
