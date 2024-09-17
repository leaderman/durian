package com.miaoyurun.durian.aigc.deepseek.request.message;

import com.miaoyurun.durian.aigc.deepseek.entity.Message;
import com.miaoyurun.durian.aigc.deepseek.entity.Role;
import com.miaoyurun.durian.common.constant.General;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserMessage extends Message {
    private String name;

    public UserMessage(String name, String content) {
        super(Role.USER, content);
        this.name = name;
    }

    public UserMessage(String content) {
        this(General.Empty, content);
    }
}
