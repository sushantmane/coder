package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P191_NumberOf1BitsTest {

    @Test
    void hammingWeight_PositiveNum() {
        assertEquals(2, P191_NumberOf1Bits.hammingWeight(12));
    }


    @Test
    void hammingWeight_NegativeNum() {
        assertEquals(31, P191_NumberOf1Bits.hammingWeight(-3));
    }
}