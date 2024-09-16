package com.miaoyurun.durian.common.constant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeneralTest {
    @Test
    public void testGeneral() {
        Assertions.assertEquals("", General.Empty);
    }
}
