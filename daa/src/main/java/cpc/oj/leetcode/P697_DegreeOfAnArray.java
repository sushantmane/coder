package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P697_DegreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer>  map = new HashMap<>();
        for (int x : nums) {
            map.compute(x, (k, v) -> v == null ? 1 : v + 1);
        }
        int maxDeg = 0;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > maxDeg) {
                list.clear();
                list.add(key);
                maxDeg = map.get(key);
            } else if (map.get(key) == maxDeg) {
                list.add(key);
            }
        }
        if (list.size() > 1 && list.size() == nums.length) {
            return 1;
        }
        int res = nums.length;
        for (int n : list) {
            int start = -1;
            int end = -1;
            for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
                if (start == -1 && nums[i] == n) {
                    start = i;
                }
                if (end == -1 && nums[j] == n) {
                    end = j;
                }
                if (start != -1 && end != -1) {
                    break;
                }
            }
            int subLen = end - start + 1;
            if (res > subLen) {
                res = subLen;
            }
        }
        return res;
    }
}
