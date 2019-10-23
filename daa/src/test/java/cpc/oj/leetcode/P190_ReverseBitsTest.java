package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P190_ReverseBitsTest {

    @Test
    void reverseBits() {
        assertEquals(-1073741825, P190_ReverseBits.reverseBits(-3));
        assertEquals(964176192, P190_ReverseBits.reverseBits(43261596));
    }
}