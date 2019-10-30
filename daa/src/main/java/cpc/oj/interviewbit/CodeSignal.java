package cpc.oj.interviewbit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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

    static boolean sudoku2(char[][] grid) {
        Set<Character> set = new HashSet<>();
        // check for rows
        for (char[] row : grid) {
            set.clear();
            for (char c : row) {
                if (Character.isDigit(c) && set.contains(c)) {
                    return false;
                }
                if (Character.isDigit(c)) {
                    set.add(c);
                }
            }
        }
        // check for columns
        for (int i = 0; i < grid.length; i++) {
            set.clear();
            for (int j = 0; j < grid.length; j++) {
                if (Character.isDigit(grid[j][i]) && set.contains(grid[j][i])) {
                    return false;
                }
                if (Character.isDigit(grid[j][i])) {
                    set.add(grid[j][i]);
                }
            }
        }
        // check for 3 x 3 grid
        for (int x = 0; x < grid.length; x += 3) {
            for (int y = 0; y < grid.length; y += 3) {
                set.clear();
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (Character.isDigit(grid[i][j]) && set.contains(grid[i][j])) {
                            return false;
                        }
                        if (Character.isDigit(grid[i][j])) {
                            set.add(grid[i][j]);
                        }
                    }
                }
            }
        }
        return true;
    }

    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char[] c : solution) {
            map.put(c[0], Character.getNumericValue(c[1]));
        }
        String[] nums = new String[3];
        int i = 0;
        for (String str : crypt) {
            String t = "";
            for (char c : str.toCharArray()) {
                t += map.get(c);
            }
            if (t.length() > 1 && t.charAt(0) == '0') {
                return false;
            }
            nums[i++] = t;
        }
        return nums[2].equals(addTwoStr(nums[0], nums[1]));
    }

    static String addTwoStr(String a, String b) {
        int carry = 0;
        String res = "";
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int x = 0;
            int y = 0;
            if (i >= 0) {
                x = Character.getNumericValue(a.charAt(i));
            }
            if (j >= 0) {
                y = Character.getNumericValue(b.charAt(j));
            }
            int sum = x + y + carry;
            res = sum % 10 + res;
            carry = sum / 10;
        }
        if (carry != 0) {
            res = carry + res;
        }
        return res;
    }

    public static void main(String[] args) {
//        String[] crypt = {"SEND", "MORE", "MONEY"};
        String[] crypt = {"TEN", "TWO", "ONE"};
        char[][] solution = {{'O','1'},
                {'T','0'},
                {'W','9'},
                {'E','5'},
                {'N','4'}};
        System.out.println(isCryptSolution(crypt, solution));
    }
}
