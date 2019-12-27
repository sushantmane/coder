package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TwoColoringGraphs {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private int n;

    public TwoColoringGraphs(int n, int[][] edges) {
        this.n = n;
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);
    }

    enum Color { RED, BLUE, UNKNOWN }

    private void twoColor() {
        Color[] colors = new Color[n];
        Arrays.fill(colors, Color.UNKNOWN);
        boolean[] discovered = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                colors[i] = Color.RED;
                if (!bfs(i, colors, discovered)) {
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + colors[i]);
        }
    }

    private boolean bfs(int src, Color[] colors, boolean[] discovered) {
        boolean[] processed = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        discovered[src] = true;
        queue.add(src);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            processed[u] = true;
            for (int v : adjList.get(u)) {
                if (discovered[v] && colors[u] == colors[v]) {
                        System.out.println("Not tow colorable. (u, v):" + u + " " + colors[u] + ", " + v + " " + colors[v]);
                        return false;
                }
                if (!discovered[v]) {
                    discovered[v] = true;
                    queue.add(v);
                    if (colors[u] == Color.RED) {
                        colors[v] = Color.BLUE;
                    } else if (colors[u] == Color.BLUE) {
                        colors[v] = Color.RED;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {3, 4},
//                {4, 5}, {2, 4}, {2, 6}, {2, 7}, {6, 7}, {8, 9}, {10, 11}, {11, 12}};

        int[][] edges = {{0, 3}, {0, 6}, {1, 2}, {1, 3},
                {2, 4}, {3, 8}, {3, 5}, {5, 6}, {5, 7}, {4, 6}, {4, 9},
                {4, 7}, {7, 8}, {8, 9}};
        TwoColoringGraphs graph = new TwoColoringGraphs(10, edges);
        graph.twoColor();
    }
}
