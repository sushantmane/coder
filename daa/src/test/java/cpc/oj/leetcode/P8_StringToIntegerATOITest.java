package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P8_StringToIntegerATOITest {

    @Test
    void myAtoi() {
        P8_StringToIntegerATOI obj = new P8_StringToIntegerATOI();
        assertEquals(42, obj.myAtoi("42"));
    }
}