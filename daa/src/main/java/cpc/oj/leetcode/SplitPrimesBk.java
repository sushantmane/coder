package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SplitPrimesBk {

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


    Map<Integer, Integer> tab = new HashMap<>();
    int backtrack(String s, int k, Set<Integer> primes) {
        if (k == s.length()) {
            return 1;
        }
        if (tab.containsKey(k)) {
            return tab.get(k);
        }

        List<Integer> cands = getCands(s, k, primes);
        int res = 0;
        for (int cand : cands) {
            res += backtrack(s, k + cand, primes);
        }
        tab.put(k, res);
        return res;
    }


    public static void main(String[] args) {
        Set<Integer> primes = generatePrimes(1000);
//        System.out.println(primes);
        StringBuilder sb = new StringBuilder();
        for (int p : primes) {
            sb.append(p);
        }
        SplitPrimesBk splitPrimes = new SplitPrimesBk();
//        splitPrimes.backtrack("31173", 0, primes);
//        System.out.println("res: " + splitPrimes.tab.get(0));
//        splitPrimes.tab.clear();
//        splitPrimes.backtrack("3175", 0, primes);
//        System.out.println("res: " + splitPrimes.tab.get(0));
//        splitPrimes.tab.clear();
//
//        splitPrimes.backtrack("11373", 0, primes);
//        System.out.println("res: " + splitPrimes.tab.get(0));
//        splitPrimes.tab.clear();

//        System.out.println(sb);
        splitPrimes.backtrack("2577692357737", 0, primes);
        System.out.println("res: " + splitPrimes.tab.get(0));
        splitPrimes.tab.clear();
    }
}
