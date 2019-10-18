package edu.sjsu.cs.cs255.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixTest {

    @Test
    void spiralMatrix() {
        int[][] expErr = {
                        {1, 2, 3},
                        {8, 9, 4},
                        {7, 6, 5}
        };
        int[][] res = SpiralMatrix.spiralMatrix(3);
        assertArrayEquals(expErr, res);
    }
}