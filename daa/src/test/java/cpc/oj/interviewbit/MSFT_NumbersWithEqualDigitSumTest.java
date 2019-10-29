package cpc.oj.interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MSFT_NumbersWithEqualDigitSumTest {

    @Test
    void solution() {
        MSFT_NumbersWithEqualDigitSum obj = new MSFT_NumbersWithEqualDigitSum();
        int[] arr = {51, 71, 17, 42};
        assertEquals(93, obj.solution(arr));

        int[] arr_1 = {42, 33, 60};
        assertEquals(102, obj.solution(arr_1));

        int[] arr_2 = {51, 32, 43};
        assertEquals(-1, obj.solution(arr_2));
    }
}