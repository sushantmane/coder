package cpc.oj.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class P8_StringToIntegerATOI {

    public int myAtoi(String str) {
        if (str.trim().length() == 0) {
            return 0;
        }
        int res = 0;
        char[] arr = str.toCharArray();
        // remove all whitespace chars
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] == ' ') {
                continue;
            }
            break;
        }
        List<Character> signs = Arrays.asList('+', '-');
        if (i < arr.length && !signs.contains(arr[i]) && !Character.isDigit(arr[i])) {
            return 0;
        }
        StringBuilder buf = new StringBuilder();
        if (signs.contains(arr[i])) {
            buf.append(arr[i]);
            i++;
        }
        while (i < arr.length) {
            if (arr[i] == '0') {
                i++;
                continue;
            }
            break;
        }
        while (i < arr.length && Character.isDigit(arr[i])) {
            buf.append(arr[i]);
            i++;
        }
        String numStr = buf.toString();
        if ((buf.length() == 0) || (buf.length() == 1 && signs.contains(numStr.charAt(0)))) {
            return 0;
        }
        if ((signs.contains(numStr.charAt(0)) && numStr.length() > 11)
                || !signs.contains(numStr.charAt(0)) && numStr.length() > 10) {
            if (numStr.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        Long l = Long.parseLong(numStr);
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(numStr);
    }
}
