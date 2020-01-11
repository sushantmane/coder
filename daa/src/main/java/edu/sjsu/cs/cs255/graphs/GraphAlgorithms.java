package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphAlgorithms {

    public static void bfs(Map<Integer, List<Integer>> adjList) {
        int[] parent = new int[adjList.size()];
        Arrays.fill(parent, -1);
        int[] distance = new int[adjList.size()];
        boolean[] discovered = new boolean[adjList.size()];
        boolean[] processed = new boolean[adjList.size()];
        List<Integer> order = new ArrayList<>();
        for (int i : adjList.keySet()) {
            if (!discovered[i]) {
                bfs(adjList, discovered, processed, i, parent, distance, order);
            }
        }

        System.out.println("BfsOrder: " + order);
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + " - d:" + distance[i] + " p:" + parent[i]);
        }
    }

    static void bfs(Map<Integer, List<Integer>> adjLst, boolean[] disco, boolean[] proc,
                    int src, int[] prn, int[] dist, List<Integer> order) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        disco[src] = true;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            order.add(u); // update order
            proc[u] = true; // mark processed
            processVertexEarly(u); // do you want to do something before processing neighbors?
            for (int v : adjLst.get(u)) {
                if (!proc[v]) {
                    processEdge(u, v); // process each (u --> v)
                }
                if (!disco[v]) {
                    disco[v] = true;
                    queue.add(v);
                    dist[v] = dist[u] + 1; // update distance
                    prn[v] = u; // update parent info
                }
            }
            processVertexLate(u);
        }
    }

    public static void processVertexEarly(int v) {
        System.out.println("Early: " + v);
    }

    public static void processVertexLate(int v) {
        System.out.println("Late: " + v);
    }

    public static void processEdge(int u, int v) {
        System.out.println("Edge: (" + u + ", " + v + ")");
    }

    public static Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            List<Integer> adjU = adjList.computeIfAbsent(u, k -> new ArrayList<>());
            adjU.add(v);
            List<Integer> adjV = adjList.computeIfAbsent(v, k -> new ArrayList<>());
            adjV.add(u);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {3, 4},
                {4, 5}, {2, 4}, {2, 6}, {2, 7}, {6, 7}};
        Map<Integer, List<Integer>> adjList = createGraph(edges);
        System.out.println(adjList);
        bfs(adjList);
    }
}
