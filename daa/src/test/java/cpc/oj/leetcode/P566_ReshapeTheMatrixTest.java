package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class P566_ReshapeTheMatrixTest {

    @Test
    void solution_1() {
        int[][] inp = {{1, 2}, {3, 4}};
        int[][] exp = {{1, 2, 3, 4}};
        int[][] act = P566_ReshapeTheMatrix.solution(inp, 1, 4);
        assertArrayEquals(exp, act);
    }

    @Test
    void solution_Ok() {
        int[][] inp = {{1, 2}, {3, 4}, {5, 6}};
        int[][] exp = {{1, 2, 3}, {4, 5, 6}};
        int[][] act = P566_ReshapeTheMatrix.solution(inp, 2, 3);
        assertArrayEquals(exp, act);
    }

    @Test
    void solution_noWayToReshape() {
        int[][] inp = {{1, 2}, {3, 4}};
        int[][] act = P566_ReshapeTheMatrix.solution(inp, 2, 4);
        assertArrayEquals(inp, act);
    }

    @Test
    void solution_noWayToReshape2() {
        int[][] inp = {{1, 2}, {3, 4}};
        int[][] act = P566_ReshapeTheMatrix.solution(inp, 3, 4);
        assertArrayEquals(inp, act);
    }
}