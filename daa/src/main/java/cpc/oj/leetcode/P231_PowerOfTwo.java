package cpc.oj.leetcode;

public class P231_PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}
