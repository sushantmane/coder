package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private final Map<Integer, List<Integer>> adjList = new HashMap<>();

    public Graph(int nVertices, int[][] edges) {
        this(nVertices, edges, false);
    }

    public Graph(int nVertices, int[][] edges, boolean directed) {
        for (int i = 0; i < nVertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            if (!directed) {
                adjList.get(v).add(u);
            }
        }
    }

    public List<Integer> getNeighbors(int u) {
        return adjList.get(u);
    }

    public Set<Integer> getVertices() {
        return adjList.keySet();
    }
}
