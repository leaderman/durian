package com.miaoyurun.durian.aigc.deepseek.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Message {
    private Role role;
    private String content;
}
