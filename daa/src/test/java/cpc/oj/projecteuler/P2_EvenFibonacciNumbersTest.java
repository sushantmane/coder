package cpc.oj.projecteuler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P2_EvenFibonacciNumbersTest {

    @Test
    void solution() {
        assertEquals(4613732,
                P2_EvenFibonacciNumbers.solution(4000000));
    }

    @Test
    void solution_UsingFormula() {
        assertEquals(4613732,
                P2_EvenFibonacciNumbers.solution_UsingFormula(4000000));
    }

    @Test
    void solution_UsingPropertyEveryThirdNumIsEven() {
        assertEquals(4613732,
                P2_EvenFibonacciNumbers.solution_UsingPropertyEveryThirdNumIsEven(4000000));
    }
}