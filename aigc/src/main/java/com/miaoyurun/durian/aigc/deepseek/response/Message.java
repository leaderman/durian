package com.miaoyurun.durian.aigc.deepseek.response;

import com.miaoyurun.durian.aigc.deepseek.model.Role;
import lombok.Data;

@Data
public class Message {
    private String content;
    private Role role;
}
