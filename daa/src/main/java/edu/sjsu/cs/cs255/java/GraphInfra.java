package edu.sjsu.cs.cs255.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphInfra {


    public static int sol(int[] a, int[] b , int n) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Map<Integer, Integer> deg = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int i = 0; i < a.length; i++) {
            int u = a[i];
            int v = b[i];
            edges.get(u).add(v);
            edges.get(v).add(u);
            deg.compute(u, (k, val) -> val == null ? 1 : val + 1);
            deg.compute(v, (k, val) -> val == null ? 1 : val + 1);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int u = a[i] - 1;
            int v = b[i] - 1;
            int dU = deg.get(u);
            int dV = deg.get(v);
            int total = dU + dV - 1;
            if (total > max) {
                max = total;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5};
        int[] b = {2, 3, 5, 6};
        int n = 6;
        System.out.println("res: " + sol(a, b, n));
    }
}
