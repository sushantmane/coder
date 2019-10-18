package cpc.oj.projecteuler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P1_Multiplesof3and5Test {

    @Test
    void solution_first10() {
        assertEquals(23, P1_Multiplesof3and5.solution(10));
    }

    @Test
    void solution_first1000() {
        assertEquals(233168, P1_Multiplesof3and5.solution(1000));
    }

    @Test
    void solution_first1000000000() {
        assertEquals(233333333166666668L, P1_Multiplesof3and5.solution(1000000000));
    }
}