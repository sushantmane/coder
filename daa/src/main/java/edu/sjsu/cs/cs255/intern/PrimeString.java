package edu.sjsu.cs.cs255.intern;

import java.util.ArrayList;
import java.util.List;

public class PrimeString {

    public static List<Integer> getPrimes(int n, int m) {
        int maxSqrt = (int) Math.sqrt(m);
        List<Integer> primes = new ArrayList<>();
        for (int i = n; i < m; i++) {
            boolean isPrime = true;
            for (int j  = 2; j <= maxSqrt; j++) {
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

    // [67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113]
    public static String solution(String str) {
        int A = 65;
        int Z = 90;
        int a = 97;
        int z = 122;
        List<Integer> primes = new ArrayList<>();
        primes.addAll(getPrimes(A, Z));
        primes.addAll(getPrimes(a, z));
        int[] primesArr = primes.stream().mapToInt(Integer::intValue).toArray();
        StringBuilder strB = new StringBuilder();
        for (char c : str.toCharArray()) {
            int val = c;
            int i = 0;
            while (i < primesArr.length && val > primesArr[i]) {
                i++;
            }
            int dest;
            if (i > 0 && (i >= primesArr.length || primesArr[i] - val >= val - primesArr[i - 1])) {
                dest = primesArr[i - 1];
            } else  {
                dest = primesArr[i];
            }
            strB.append((char) dest);
        }
        return strB.toString();
    }
}