package edu.sjsu.cs.cs255.intern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeStringTest {

    @Test
    void solution() {
        assertEquals("CCa", PrimeString.solution("ABc"));
        assertEquals("YYq", PrimeString.solution("ZZz"));
        assertEquals("qqq", PrimeString.solution("zzz"));
        assertEquals("aaa", PrimeString.solution("aaa"));
        assertEquals("CCC", PrimeString.solution("AAA"));
        assertEquals("CCC", PrimeString.solution("ADE"));
        assertEquals("CCG", PrimeString.solution("ADF"));
    }
}