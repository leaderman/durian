package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.miaoyurun.durian.aigc.deepseek.model.Role;
import com.miaoyurun.durian.common.constant.General;

public class AssistantMessage extends Message {
    public AssistantMessage(String name, String content) {
        super(name, Role.USER, content);
    }

    public AssistantMessage(String content) {
        this(General.Empty, content);
    }
}
