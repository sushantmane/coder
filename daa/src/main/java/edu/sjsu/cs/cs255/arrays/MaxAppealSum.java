package edu.sjsu.cs.cs255.arrays;

public class MaxAppealSum {

    public static int solution(int[] nums) {
        int[] res = new int[2];

        int maxAppeal = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int ta = appeal(nums, i, j);
                if (ta > maxAppeal) {
                    maxAppeal = ta;
//                    res[0] = i;
//                    res[1] = j;
                }
            }
        }

        return maxAppeal;
    }

    public static int appeal(int[] nums, int i, int j) {
        return nums[i] + nums[j] + i - j;
    }
}
