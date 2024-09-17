package com.miaoyurun.durian.aigc.deepseek.response;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ToolCallType {
    FUNCTION("function");

    @JsonValue
    private final String name;
}
