package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Type {
    TEXT("text"),
    JSON_OBJECT("json_object");

    @JsonValue
    private final String name;
}
