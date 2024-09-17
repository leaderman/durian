package com.miaoyurun.durian.aigc.deepseek.request.tool;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ToolChoiceName {
    NONE("none"),
    AUTO("auto"),
    REQUIRED("required");

    @JsonValue
    private final String name;
}
