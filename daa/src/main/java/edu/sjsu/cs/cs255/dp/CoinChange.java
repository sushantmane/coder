package edu.sjsu.cs.cs255.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CoinChange {

    // brute force
    public static int coinChange(Set<Integer> coins, int target) {
        if (target == 0) {
            return 0;
        }

        int numCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (target - coin >= 0) {
                numCoins = Math.min(numCoins, 1 + coinChange(coins, target - coin));
            }
        }

        return numCoins;
    }

    public static int coinChangeMem(Set<Integer> coins, int target, Map<Integer, Integer> mem) {
        if (target == 0) {
            return 0;
        }

        Integer nCoins = mem.get(target);
        if (nCoins != null) {
            return nCoins;
        }
        int numCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if ((target - coin) >= 0) {
                numCoins = Math.min(numCoins, 1 + coinChangeMem(coins, target - coin, mem));
            }
        }
        mem.put(target, numCoins);
        return numCoins;
    }

    public static int coinChangeBottomUp(Set<Integer> coins, int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        for (int i = 1; i <= n; i++) {
            int numCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    numCoins = Math.min(numCoins, 1 + cache[i - coin]);
                }
            }
            cache[i] = numCoins;
        }
        return cache[n];
    }

    public static void main(String[] args) {
        int n = 12;
        Set<Integer> coins = new HashSet<>(Arrays.asList(1, 5, 10, 25));
        System.out.println(coinChange(coins, n));
        System.out.println(coinChangeMem(coins, n, new HashMap<>()));
        System.out.println(coinChangeBottomUp(coins, n));
    }

}
