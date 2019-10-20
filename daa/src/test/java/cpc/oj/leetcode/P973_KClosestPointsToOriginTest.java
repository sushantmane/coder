package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

class P973_KClosestPointsToOriginTest {

    @Test
    void kClosest() {
        int[][] arr = new int[][] {{3,3}, {5,-1}, {-2,4}};
        int K = 2;
        P973_KClosestPointsToOrigin kClosest = new P973_KClosestPointsToOrigin();
        int[][] res = kClosest.kClosest(arr, K);
        for (int[] pt : res) {
            System.out.println(pt[0] + ", " + pt[1]);
        }
    }
}