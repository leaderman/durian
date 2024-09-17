package com.miaoyurun.durian.aigc.deepseek.request.tool;

import com.miaoyurun.durian.aigc.deepseek.request.Function;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FunctionTool extends Tool {
    private final Function function;

    public FunctionTool(Function function) {
        super(ToolType.FUNCTION);

        this.function = function;
    }
}
