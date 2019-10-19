package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P566_ReshapeTheMatrix {

    public static int[][] solution(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }

        List<Integer> list = new ArrayList<>();
        for (int[] row : nums) {
            for (int f : row) {
                list.add(f);
            }
        }

        int k = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = list.get(k++);
            }
        }
        return res;
    }
}
