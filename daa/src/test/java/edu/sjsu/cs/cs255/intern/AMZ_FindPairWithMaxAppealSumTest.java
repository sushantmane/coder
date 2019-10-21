package edu.sjsu.cs.cs255.intern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AMZ_FindPairWithMaxAppealSumTest {

    @Test
    void solution() {
        int[] arr = {1, 3, -1};
        int[] exp = {1, 1};
        int[] res = AMZ_FindPairWithMaxAppealSum.solution(arr);
        assertArrayEquals(exp, res);

        arr = new int[]{1, 6, 1, 1, 1, 1, 7};
        exp = new int[]{1, 6};
        res= AMZ_FindPairWithMaxAppealSum.solution(arr);
        assertArrayEquals(exp, res);

        arr = new int[]{6, 2, 7, 4, 4, 1, 6};
        exp = new int[]{0, 6};
        res = AMZ_FindPairWithMaxAppealSum.solution(arr);
        assertArrayEquals(exp, res);
    }
}