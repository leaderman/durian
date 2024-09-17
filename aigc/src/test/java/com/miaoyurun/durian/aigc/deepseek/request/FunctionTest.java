package com.miaoyurun.durian.aigc.deepseek.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class FunctionTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFunction() throws JsonProcessingException {
        Function function = new Function();

        function.setName("getWeather");
        function.setDescription("Get the weather of a city.");
        function.setParameters(List.of(new Parameter("city", "The city name.", JsonType.STRING, true)));

        log.info("function: {}", objectMapper.writeValueAsString(function));
    }
}
