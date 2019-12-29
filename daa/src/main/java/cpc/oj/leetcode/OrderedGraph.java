package cpc.oj.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class OrderedGraph {

    private final Map<Integer, List<Integer>> adjList = new HashMap<>();
    private final int V; // number of vertices

    public OrderedGraph(int V, int[][] edges) {
        this.V = V;
        for (int i = 0; i < V; i++) {
            adjList.put(i, new LinkedList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }
    }

    public List<Integer> getNeighbors(int u) {
        return adjList.get(u);
    }

    public int getV() {
        return V;
    }

    public int[][] getDegrees() {
        int[][] degree = new int[V][2];
        for (int u : adjList.keySet()) {
            degree[u][1] = getNeighbors(u).size();
            for (int v : getNeighbors(u)) {
                degree[v][0] += 1;
            }
        }
        return degree;
    }
}

