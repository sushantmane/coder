package edu.sjsu.cs.cs255.intern;

public class ReadAllMails {

    public static int solution(int n, int[] a) {
        int ops = 0;
        int state = 0; // 0 - list 1 - content
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                if (state == 0) {
                    state = 1;
                }
                ops++;
            } else {
                if (state == 1) {
                    ops++;
                    state = 0;
                }
            }
        }
        return ops;
    }
}
