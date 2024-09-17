package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum JsonType {
    STRING("string"),
    NUMBER("number"),
    INTEGER("integer"),
    OBJECT("object"),
    ARRAY("array"),
    BOOLEAN("boolean"),
    NULL("null");

    @JsonValue
    private final String name;
}
