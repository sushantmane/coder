package cpc.oj.projecteuler;

public class P1_Multiplesof3and5 {

    // use series: 1 + 2 + 3 +...+ n = n * (n + 1) / 2
    private static long sumDivBy(int target, int d) {
        long m = target / d; // how many ele are multiple of d
        return (d *  (m * ( m + 1) / 2));
    }

    public static long solution(int n) {
        return sumDivBy(n - 1, 3)
                + sumDivBy(n - 1, 5)
                - sumDivBy(n - 1, 3 * 5);
    }
}