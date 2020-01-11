package edu.sjsu.cs.cs255.intern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTreatsTest {

    @Test
    void solution() {
        int[] a = {1, 0, 1};
        assertEquals("NO", PizzaTreats.solution(3, a));

        int[] b = {1, 2, 1, 2};
        assertEquals("YES", PizzaTreats.solution(4, b));
    }
}