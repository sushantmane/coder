package cpc.oj.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P997_FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {
        TrustGraph graph = new TrustGraph(N, trust);
        int[][] degrees = graph.getDegrees();
        for (int i = 0; i < N; i++) {
             int in = degrees[i][0];
             int out = degrees[i][1];
             if (in == N - 1 && out == 0) {
                 return i + 1;
             }
        }
        return -1;
    }
}

final class TrustGraph {

    private final Map<Integer, List<Integer>> adjList = new HashMap<>();
    private final int V; // number of vertices

    public TrustGraph(int V, int[][] edges) {
        this.V = V;
        for (int i = 1; i <= V; i++) {
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
            degree[u - 1][1] = getNeighbors(u).size();
            for (int v : getNeighbors(u)) {
                degree[v - 1][0] += 1;
            }
        }
        return degree;
    }
}


