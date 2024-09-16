package com.miaoyurun.durian.aigc.deepseek.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Usage {
    @JsonProperty("completion_tokens")
    private int completionTokens;
    @JsonProperty("prompt_tokens")
    private int promptTokens;
    @JsonProperty("prompt_cache_hit_tokens")
    private int promptCacheHitTokens;
    @JsonProperty("prompt_cache_miss_tokens")
    private int promptCacheMissTokens;
    @JsonProperty("total_tokens")
    private int totalTokens;
}
