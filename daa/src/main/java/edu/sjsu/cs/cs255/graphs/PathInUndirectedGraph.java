package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PathInUndirectedGraph {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private int nVertices;

    private List<Integer> bfs(int nVertices, int[][] edges, int src, int dest) {
        boolean[] discovered = new boolean[nVertices];
        boolean[] processed = new boolean[nVertices];
        int[] parent = new int[nVertices];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        discovered[src] = true;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            processed[u] = true;
            for (int v : adjList.get(u)) {
                if (!discovered[v]) {
                    queue.add(v);
                    discovered[v] = true;
                    parent[v] = u;
                }
                if (v == dest) {
                    break;
                }
            }
        }

        List<Integer> path = new LinkedList<>();
        int d = dest;
        while (d != src) {
            path.add(d);
            d = parent[d];
            if (d == -1) {
                path.clear();
                break;
            }
        }
        if (path.isEmpty()) {
            return path;
        }
        path.add(src);
        Collections.reverse(path);
        return path;
    }

    private void initGraph(int nVertices, int[][] edges) {
        this.nVertices = nVertices;
        for (int i = 0; i < nVertices; i++) {
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

    public static void main(String[] args) {
        PathInUndirectedGraph demo = new PathInUndirectedGraph();
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {3, 4},
                {4, 5}, {2, 4}, {2, 6}, {2, 7}, {6, 7}};
        demo.initGraph(8, edges);
        List<Integer> path = demo.bfs(8, edges, 5, 0);
        System.out.println(path);
    }
}
