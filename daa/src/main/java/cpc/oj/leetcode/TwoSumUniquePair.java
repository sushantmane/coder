package cpc.oj.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TwoSumUniquePair {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 45, 46, 46};
        int target = 47;

//        nums = new int[]{1, 5, 1, 5};
//        target = 6;
//
//        nums = new int[]{1, 1, 1, 1, 1, 1, 1};
//        target = 2;
//
//        nums = new int[]{1, 1};
//        target = 2;

        nums = new int[]{5, 6, 5, 7, 7, 8};
        target = 13;

        nums = new int[]{2, 6, 7, 1, 8, 3};
        target = 10;


        Arrays.sort(nums);
        Arrays.stream(nums).forEach(k -> System.out.print(k + " "));
        System.out.println();
        List<int[]> pairs = new LinkedList<>();
        int i = 0;
        int j = nums.length - 1;
        int sum = 0;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                pairs.add(new int[]{nums[i], nums[j]});
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1] && nums[j] == nums[j + 1]) {
                    i++;
                    j--;
                }
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }
        System.out.println(pairs.size());
    }
}
