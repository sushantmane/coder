package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphDemo {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private int nVertices;
    private int nEdges;

    private void processVertexEarly(int u) {
        System.out.println("ProcessVertexEarly u:" + u);
    }

    private void processVertexLate(int u) {
        System.out.println("ProcessVertexLate u:" + u);
    }

    private void processEdge(int u, int v) {
        System.out.println("Process edge(" + u + ", " + v + ")");
        nEdges++;
    }

    private void bfs() {
        int source = 0;
        boolean[] discovered = new boolean[nVertices];
        boolean[] processed = new boolean[nVertices];
        int[] parent = new int[nVertices];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        discovered[source] = true;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            processVertexEarly(u);
            processed[u] = true;
            for (int v : adjList.get(u)) {
                if (!processed[v]) {
                    processEdge(u, v);
                }
                if (!discovered[v]) {
                    queue.add(v);
                    discovered[v] = true;
                    parent[v] = u;
                }
            }
            processVertexLate(u);
        }
        for (int i = 0; i < nVertices; i++) {
            System.out.println(i + " <-- " + parent[i]);
        }
        System.out.println("nEdges:" + nEdges);
        int s = 0;
        int d = 5;
        List<Integer> path = new LinkedList<>();
        path.add(d);
        while (true) {
            d = parent[d];
            path.add(d);
            if (d == s) {
                break;
            }
            if (d == -1) {
                System.out.println("Path does not exist");
            }
        }
        Collections.reverse(path);
        System.out.println(path);
    }

    private void initGraph(int nVertices, int[][] edges, boolean directed) {
        this.nVertices = nVertices;
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
        System.out.println(adjList);
    }

    public static void main(String[] args) {
        GraphDemo demo = new GraphDemo();
        int nVertices = 2;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {3, 4},
                {4, 5}, {2, 4}, {2, 6}, {2, 7}, {6, 7}};
        demo.initGraph(8, edges, false);
        demo.bfs();
    }
}
