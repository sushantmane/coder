package cpc.oj.leetcode;

public class P191_NumberOf1Bits {

    public static int hammingWeight(int num) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            int res = num & (1 << i);
            if (res == 0) {
                continue;
            }
            count++;
        }
        return count;
    }
}
