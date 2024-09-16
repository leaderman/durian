package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.miaoyurun.durian.aigc.deepseek.model.Role;
import lombok.Data;

@Data
public abstract class Message {
    protected final String name;
    protected final Role role;
    protected final String content;
}
