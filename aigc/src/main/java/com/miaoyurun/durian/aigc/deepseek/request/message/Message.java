package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.miaoyurun.durian.aigc.deepseek.model.Role;
import lombok.Data;

@Data
public abstract class Message {
    private final String name;
    private final Role role;
    private final String content;
}
