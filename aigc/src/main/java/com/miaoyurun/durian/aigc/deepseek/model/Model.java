package com.miaoyurun.durian.aigc.deepseek.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Model {
    CHAT("deepseek-chat"),
    CODER("deepseek-coder");

    @JsonValue
    private final String name;
}
