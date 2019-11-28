package cpc.oj.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
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

    static int[][] rotateMatrix(int[][] arr, int k) {
        while (k != 0) {
            arr = rotateMatrix(arr);
            k--;
        }
        return arr;
    }

    static int[][] rotateMatrix(int[][] arr) {
        int m = arr.length;
        int[][] res = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || i + j == m - 1) {
                    res[i][j] = arr[i][j];
                } else {
                    //res[j][m - 1 - i] = arr[i][j];
                    res[i][j] = arr[m - 1 - j][i];
                }
            }
        }
        return res;
    }

    static int evenDigitNumbers(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (String.valueOf(x).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    static int getFact(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    static int ncr(int n, int r) {
        return getFact(n) / (getFact(r) * getFact(n - r));
    }

    static int digitAnagrams(int[] a) {
        Map<String, Integer> map = new HashMap<>();
        for (int i : a) {
            String s = String.valueOf(i);
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            map.compute(String.valueOf(ca), (k, v) -> v == null ? 1 : v + 1);
        }
        int count = 0;
        for (String k : map.keySet()) {
            if (map.get(k) > 1) {
                count += ncr(map.get(k), 2);
            }
        }
        return count;
    }

    static int[] mostFrequentDigits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            while (i > 0) {
                map.compute(i % 10, (k, v) -> v == null ? 1 : v + 1);
                i = i / 10;
            }
        }
        return new int[0];
    }

    static int[][] borderSort(int[][] mat) {
        int n = mat.length;
        int k = 0;
        int layer = 0;
        int i = 0;
        int j = 0;
        List<Integer> flat = new ArrayList<>();
        while (k < n * n) {
            i = layer;
            j = layer;
            List<Integer> layerArr = new ArrayList<>();
            while (j < n - layer) {
                layerArr.add(mat[i][j]);
                k++;
                j++;
            }
            j--;
            i++;
            while (i < n - layer) {
                layerArr.add(mat[i][j]);
                k++;
                i++;
            }
            i--;
            j--;
            while (j >= layer) {
                layerArr.add(mat[i][j]);
                k++;
                j--;
            }
            i--;
            j++;
            while (i > layer) {
                layerArr.add(mat[i][j]);
                k++;
                i--;
            }
            layer++;
            Collections.sort(layerArr);
            flat.addAll(layerArr);
        }

        k = 0;
        layer = 0;
        while (k < n * n) {
            i = layer;
            j = layer;
            while (j < n - layer) {
                mat[i][j] = flat.get(k);
                k++;
                j++;
            }
            j--;
            i++;
            while (i < n - layer) {
                mat[i][j] = flat.get(k);
                k++;
                i++;
            }
            i--;
            j--;
            while (j >= layer) {
                mat[i][j] = flat.get(k);
                k++;
                j--;
            }
            i--;
            j++;
            while (i > layer) {
                mat[i][j] = flat.get(k);
                k++;
                i--;
            }
            layer++;
        }
        return mat;
    }

    private void testRotateMatrixNTimes() {
        int[][] arr = {
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {11, 12, 13, 14},
                {16, 17, 18, 19},
        };

        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        System.out.println("--");
        int[][] res = rotateMatrix(arr, 3);
        for (int[] a : res) {
            for (int i : a) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static int bestSquares(int[][] m, int k) {
        if (m.length == 0) {
            return 0;
        }

        List<List<Integer>> lists = new ArrayList<>();

        int c = m[0].length;
        int r = m.length;
        for (int i = 0; i <= (r - k); i++) {
            for (int j = 0; j <= (c - k); j++) {
//                System.out.println("i:" + i + " j:" + j);
                List<Integer> lt = new ArrayList<>();
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        lt.add(m[i + x][j + y]);
//                        System.out.println(m[i + x][j + y]+ " ");
                    }
//                    System.out.println();
                }
                lists.add(lt);
            }
        }

        System.out.println(lists);

        int sum = 0;
        List<Integer> sums = new ArrayList<>();
        for (List<Integer> lt : lists) {
            sum = 0;
            for (int i : lt) {
                sum += i;
            }
            sums.add(sum);
        }
        List<Integer> sumsCopy = new ArrayList<>(sums);

        Collections.sort(sums);
        System.out.println(sums);
        int max = sums.get(sums.size() - 1);
        System.out.println(max);
        System.out.println(sumsCopy);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < sumsCopy.size(); i++) {
            if (sumsCopy.get(i) == max) {
                set.addAll(lists.get(i));
            }
        }

        sum = 0;
        for (int i : set) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(set);
        return 0;
    }

    public static void main(String[] args) {
//        int k = 2;
//        int[][] m = {{1, 0, 1, 5, 6},
//                {3, 3, 0, 3, 3},
//                {2, 9, 2, 1, 2},
//                {0, 2, 4, 2, 0}};
//        System.out.println(bestSquares(m, k));

        String s = "ab12c";
        String t = "1zz456";

        System.out.println(removeOneDigit(s, t));
    }

    public static int removeOneDigit(String s, String t) {
        int ways = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            String sCmp = "";
            if (Character.isDigit(sChars[i])) {
                for (int k = 0; k < s.length(); k++) {
                    if (k == i) {
                        continue;
                    }
                    System.out.println("*** " + sCmp);
                    sCmp = sCmp + sChars[k];
                }
                if (sCmp.compareTo(t) < 0) {
                    System.out.println(sCmp + " :: " + t);
                    ways++;
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            String tCmp = "";
            if (Character.isDigit(tChars[i])) {
                for (int k = 0; k < t.length(); k++) {
                    if (k == i) {
                        continue;
                    }
                    tCmp += tChars[k];
                }
                if (s.compareTo(tCmp) < 0) {
                    System.out.println(s + " " + tCmp);
                    ways++;
                }
            }
        }

        return ways;
    }
}
