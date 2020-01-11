package edu.sjsu.cs.cs255.intern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringWeightTest {

    @Test
    void solution() {
        int n = 110;
        int[] arr = {4, 2, 1};
        assertEquals(6, StringWeight.solution(n, arr));

        n = 11;
        arr = new int[]{4, 0, 1};
        assertEquals(3, StringWeight.solution(n, arr));
    }
}