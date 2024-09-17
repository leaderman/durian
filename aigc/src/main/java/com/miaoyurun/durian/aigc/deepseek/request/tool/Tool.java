package com.miaoyurun.durian.aigc.deepseek.request.tool;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Tool {
    private final ToolType type;
}
