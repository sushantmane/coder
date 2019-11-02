package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P697_DegreeOfAnArrayTest {

    @Test
    void findShortestSubArray() {
        int[] arr = {1, 2, 2, 3, 1};
        int res = P697_DegreeOfAnArray.findShortestSubArray(arr);
        assertEquals(2, res);
    }

    @Test
    void findShortestSubArray1() {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};
        int res = P697_DegreeOfAnArray.findShortestSubArray(arr);
        assertEquals(6, res);
    }

    @Test
    void findShortestSubArray_Empty() {
        int[] arr = {};
        int res = P697_DegreeOfAnArray.findShortestSubArray(arr);
        assertEquals(arr.length, res);
    }

    @Test
    void findShortestSubArray_Unique() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int res = P697_DegreeOfAnArray.findShortestSubArray(arr);
        assertEquals(1, res);
    }

    @Test
    void findShortestSubArray_Same() {
        int[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int res = P697_DegreeOfAnArray.findShortestSubArray(arr);
        assertEquals(arr.length, res);
    }
}