package edu.sjsu.cs.cs255.intern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrokenCalculatorTest {

    @Test
    void solution() {
        assertEquals(2, BrokenCalculator.solution(2, 3));
        assertEquals(2, BrokenCalculator.solution(5, 8));
        assertEquals(3, BrokenCalculator.solution(3, 10));
    }
}