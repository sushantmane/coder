package edu.sjsu.cs.cs255.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BestSightseeingPairTest {

    @Test
    void maxScoreSightseeingPair() {
        int[] nums = {8,1,5,2,6};
        int res = BestSightseeingPair.maxScoreSightseeingPair(nums);
        assertEquals(11, res);

        nums = new int[]{1, 2, 2};
        res = BestSightseeingPair.maxScoreSightseeingPair(nums);
        assertEquals(3, res);

        nums = new int[]{7,2,6,6,9,4,3};
        res = BestSightseeingPair.maxScoreSightseeingPair(nums);
        assertEquals(14, res);

        nums = new int[]{6,3,7,4,7,6,6,4,9};
        res = BestSightseeingPair.maxScoreSightseeingPair(nums);
        assertEquals(13, res);
    }
}