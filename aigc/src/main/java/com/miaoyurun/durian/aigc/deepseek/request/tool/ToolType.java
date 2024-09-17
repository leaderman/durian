package com.miaoyurun.durian.aigc.deepseek.request.tool;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ToolType {
    FUNCTION("function");

    @JsonValue
    private final String name;
}
