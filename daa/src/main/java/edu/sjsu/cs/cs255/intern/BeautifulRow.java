package edu.sjsu.cs.cs255.intern;

public class BeautifulRow {

    public static int solution(int n, int[] arr) {
        int[] inc = new int[n];
        int[] dec = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[i] > arr[j]) && (inc[i] < inc[j] + 1)) {
                    inc[i] = inc[j] + 1;
                }
                if ((arr[n - i - 1] > arr[n - j - 1]) && (dec[i] < dec[j] + 1)) {
                    dec[i] = dec[j] + 1;
                }
            }
        }
        int max = inc[0] + dec[n - 1];
        for (int i = 0; i < n; i++) {
            max =  Math.max(max, inc[i] + dec[n - i - 1]);
        }
        return n - max - 1;
    }
}
