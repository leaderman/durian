package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.miaoyurun.durian.aigc.deepseek.entity.Role;
import com.miaoyurun.durian.common.constant.General;

public class UserMessage extends Message {
    public UserMessage(String name, String content) {
        super(name, Role.USER, content);
    }

    public UserMessage(String content) {
        this(General.Empty, content);
    }
}
