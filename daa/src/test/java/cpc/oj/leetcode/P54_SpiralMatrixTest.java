package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P54_SpiralMatrixTest {

    @Test
    void spiralOrder() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        P54_SpiralMatrix obj = new P54_SpiralMatrix();
        List<Integer> res = obj.spiralOrder(mat);
        List<Integer> expRes = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertEquals(expRes, res);
    }

    @Test
    void spiralOrder_4By3() {
        int[][] mat = {
                {1, 2, 3, 10},
                {4, 5, 6, 11},
                {7, 8, 9, 12}
        };

        P54_SpiralMatrix obj = new P54_SpiralMatrix();
        List<Integer> res = obj.spiralOrder(mat);
        List<Integer> expRes = Arrays.asList(1, 2, 3, 10, 11, 12, 9, 8, 7, 4, 5, 6);
        assertEquals(expRes, res);
    }

    @Test
    void spiralOrder_1By1() {
        int[][] mat = {
                {3},
                {2}
        };

        P54_SpiralMatrix obj = new P54_SpiralMatrix();
        List<Integer> res = obj.spiralOrder(mat);
        List<Integer> expRes = Arrays.asList(3, 2);
        assertEquals(expRes, res);
    }
}