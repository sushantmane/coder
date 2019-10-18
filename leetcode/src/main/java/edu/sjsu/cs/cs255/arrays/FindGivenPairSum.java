package edu.sjsu.cs.cs255.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindGivenPairSum {

    public static int[] solutionWithSort(int[] nums, int target) {
        target -= 30;
        int[] res = {-1, -1};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], i);
            }
        }

        Arrays.sort(nums);
        Arrays.stream(nums).forEach(k -> System.out.print(k + " "));
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                int x = map.get(nums[i]);
                int y = map.get(nums[j]);
                if (x < y) {
                    res[0] = x;
                    res[1] = y;
                } else {
                    res[0] = y;
                    res[1] = x;
                }

                return res;
            }
            if (sum < target) {
                i++;
                continue;
            }
            if (sum > target) {
                j--;
                continue;
            }
        }
        return res;
    }

    public static int[] solutionWithHT(int[] nums, int target) {
        target -= 30;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = {-1, -1};

        int[] maxPair = {-1, -1};
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(target - nums[i], i);
                continue;
            } else {
                int x = map.get(nums[i]);
                Integer[] tmp = {x, i};
//                results.add(tmp);
            }
        }


        return maxPair;
    }

}
