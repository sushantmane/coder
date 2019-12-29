package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private final Map<Integer, List<Integer>> adjList = new HashMap<>();
    private final int nVertices;
    private final boolean directed;

    public Graph(int nVertices, int[][] edges) {
        this(nVertices, edges, false);
    }

    public Graph(int nVertices, int[][] edges, boolean directed) {
        this.nVertices = nVertices;
        this.directed = directed;
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

    public boolean isDirected() {
        return directed;
    }

    public int getNVertices() {
        return nVertices;
    }

    @Override
    public String toString() {
        String str = "";
        for (int u : adjList.keySet()) {
            str = str + u + ": " + adjList.get(u) + "\n";
        }
        return str;
    }
}
