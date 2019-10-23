package cpc.oj.leetcode;

public class P190_ReverseBits {

    public static int reverseBits(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int res = n & (1 << i);
            if (res == 0) {
                continue;
            } else {
                sum += 1 << (31 - i);
            }
        }
        return sum;
    }
}
