package cpc.oj.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P997_FindTheTownJudgeTest {

    private P997_FindTheTownJudge obj;

    @BeforeEach
    public void setup() {
        obj = new P997_FindTheTownJudge();
    }

    @Test
    void findJudge_Test1() {
        int N = 2;
        int[][] trust = {{1, 2}};
        int res = 2;
        assertEquals(res, obj.findJudge(N, trust));
    }

    @Test
    void findJudge_Test2() {
        int N = 3;
        int[][] trust = {{1, 3}, {2, 3}};
        int res = 3;
        assertEquals(res, obj.findJudge(N, trust));
    }

    @Test
    void findJudge_Test3() {
        int N = 3;
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int res = -1;
        assertEquals(res, obj.findJudge(N, trust));
    }

    @Test
    void findJudge_Test4() {
        int N = 3;
        int[][] trust = {{1, 2}, {2, 3}};
        int res = -1;
        assertEquals(res, obj.findJudge(N, trust));
    }

    @Test
    void findJudge_Test5() {
        int N = 4;
        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int res = 3;
        assertEquals(res, obj.findJudge(N, trust));
    }
}