package com.miaoyurun.durian.aigc.deepseek.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Parameter {
    private String name;
    private String description;
    private JsonType type;
    private boolean required;
}
