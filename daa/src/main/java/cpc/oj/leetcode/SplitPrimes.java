package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SplitPrimes {

    public static Set<Integer> generatePrimes(int n) {
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            boolean isPrime = true;
            for (int j = 2; j <= sqrt; j++) {
                if (i == j) {
                    continue;
                }
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    List<Integer> getCands(String s, int k, Set<Integer> primes) {
        List<Integer> candLens = new ArrayList<>(3);
        for (int i = 1; i <= 3; i++) {
            if ((i + k) <= s.length() && primes.contains(Integer.parseInt(s.substring(k, k + i)))) {
                candLens.add(i);
            }
        }
        return candLens;
    }

    int count = 0;
    void backtrack(String s, int k, Set<Integer> primes) {
        if (k == s.length()) {
            count++;
            return;
        }

        List<Integer> cands = getCands(s, k, primes);
        for (int cand : cands) {
            backtrack(s, k + cand, primes);
        }
    }


    public static void main(String[] args) {
        Set<Integer> primes = generatePrimes(1000);
        SplitPrimes splitPrimes = new SplitPrimes();
//        String s = "31173";
//        splitPrimes.backtrack(s, 0, primes);
//        System.out.println("res: " + splitPrimes.res);
//

        splitPrimes.backtrack("25776923577372635211152313269", 0, primes);
        System.out.println("res: " + splitPrimes.count);
    }
}
