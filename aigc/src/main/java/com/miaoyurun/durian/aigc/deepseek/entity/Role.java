package com.miaoyurun.durian.aigc.deepseek.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant");

    @JsonValue
    private final String name;
}
