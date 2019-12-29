package edu.sjsu.cs.cs255.graphs;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class TopologicalSort {

    public static List<Integer> sort (Graph graph) {
        if (!graph.isDirected()) {
            throw new IllegalArgumentException("Undirected graph");
        }
        boolean[] explored = new boolean[graph.getNVertices()];
        List<Integer> topSorted = new LinkedList<>();
        for (int i = 0; i < graph.getNVertices(); i++) {
            if (!explored[i]) {
                List<Integer> processed = new LinkedList<>();
                dfs(graph, i, explored, processed);
                topSorted.addAll(processed);
            }
        }
        Collections.reverse(topSorted);
        System.out.println(topSorted);
        return new LinkedList<>();
    }

    private static void dfs(Graph graph, int u, boolean[] explored, List<Integer> processed) {
        if (explored[u]) {
            return;
        }
        explored[u] = true;
        for (int v : graph.getNeighbors(u)) {
            if (!explored[v]) {
                dfs(graph, v, explored, processed);
            }
        }
        processed.add(u);
    }
}