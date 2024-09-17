package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.miaoyurun.durian.aigc.deepseek.entity.Role;
import com.miaoyurun.durian.common.constant.General;

public class SystemMessage extends Message {
    public SystemMessage(String name, String content) {
        super(name, Role.SYSTEM, content);
    }

    public SystemMessage(String content) {
        this(General.Empty, content);
    }
}
