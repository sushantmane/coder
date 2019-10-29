package cpc.oj.interviewbit;

import java.util.LinkedHashMap;
import java.util.Map;

public class CodeSignal {

    static char firstNotRepeatingCharacter(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '_';
    }

    static int[][] rotateImage(int[][] a) {
        int n = a.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = a[i][j];
            }
        }
        return res;
    }
}
