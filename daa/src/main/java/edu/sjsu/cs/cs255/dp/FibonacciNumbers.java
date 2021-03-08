package edu.sjsu.cs.cs255.dp;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {

    public static int getFib(int n) {
        if (n < 2) {
            return n;
        }

        return getFib(n - 1) + getFib(n - 2);
    }

    public static int getFibMem(int n, Map<Integer, Integer> table) {
        if (n < 2) {
            return n;
        }

        if (table.containsKey(n)) {
            return table.get(n);
        }
        int v = getFibMem(n - 1, table) + getFibMem(n - 2, table);
        table.put(n, v);
        return v;
    }

    public static int getFib(int n, int[] cache) {
        if (cache[n] == -1) {
            cache[n] = getFib(n - 1) + getFib(n - 2);
        }
        return cache[n];
    }

    public static int getFibBottomUp(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("fib(" + n + "): " + getFib(n));
        System.out.println("fib(" + n + "): " + getFibMem(n, new HashMap<>()));

        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;
        System.out.println("fib(" + n + "): " + getFib(n, cache));
        System.out.println("fib(" + n + "): " + getFibBottomUp(n));

    }
}
