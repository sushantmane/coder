package cpc.oj.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// directed graph
public final class CourseGraph {

    private final Map<Integer, List<Integer>> adjList = new HashMap<>();
    private final int V; // number of vertices

    public CourseGraph(int V, int[][] edges) {
        this.V = V;
        for (int i = 0; i < V; i++) {
            adjList.put(i, new LinkedList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public List<Integer> getNeighbors(int u) {
        return adjList.get(u);
    }

    public int getV() {
        return V;
    }
}
