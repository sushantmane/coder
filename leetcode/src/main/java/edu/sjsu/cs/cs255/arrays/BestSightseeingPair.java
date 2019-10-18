package edu.sjsu.cs.cs255.arrays;

public class BestSightseeingPair {

    public static int maxScoreSightseeingPair(int[] nums) {
        int res = 0;
        int score = 0;
        int iMax = nums[0]; // nums[i] + i
        for (int i = 1; i < nums.length; i++) {
            score = iMax + nums[i] - i;
            if (score > res) {
                    res = score;
            }

            if (iMax < (nums[i] + i)) {
                iMax = nums[i] + i;
            }
        }
        return res;
    }
}
