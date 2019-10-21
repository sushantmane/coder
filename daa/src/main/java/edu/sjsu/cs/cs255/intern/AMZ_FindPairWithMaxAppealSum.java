package edu.sjsu.cs.cs255.intern;

public class AMZ_FindPairWithMaxAppealSum {

    public static int[] solution(int[] nums) {
        int res = 2 * nums[0];
        int iMax = nums[0];
        int iPos = 0;
        int selfScore = 0;
        int ijScore = 0;
        int[] resPos = new int[2];

        for (int i = 1; i < nums.length; i++) {
            selfScore = 2 * nums[i];
            ijScore = nums[i] + nums[iPos] + (i - iPos);

            if (selfScore > ijScore && selfScore > res) {
                res = selfScore;
                resPos[0] = i;
                resPos[1] = i;
            }

            if (ijScore > selfScore && ijScore > res) {
                res = ijScore;
                resPos[0] = iPos;
                resPos[1] = i;
            }

            if (iMax <= nums[i] - i) {
                iMax = nums[i] - i;
                iPos = i;
            }
        }
        return resPos;
    }
}
