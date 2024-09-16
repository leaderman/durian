package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StreamOptions {
    @JsonProperty("include_usage")
    private boolean includeUsage;
}
