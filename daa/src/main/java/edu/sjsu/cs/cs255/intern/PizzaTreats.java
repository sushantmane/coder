package edu.sjsu.cs.cs255.intern;

public class PizzaTreats {

    public static String solution(int n, int[] a) {
        int reminder = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                reminder = a[i] % 2;
                continue;
            }
            reminder = (a[i] - reminder) % 2;
            if (reminder < 0) {
                return "NO";
            }
        }
        if (reminder == 0) {
            return "YES";
        }
        return "NO";
    }
}
