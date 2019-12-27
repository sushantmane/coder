package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class UnorderedGraph {

    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private int nVertices;

    private UnorderedGraph(int nVertices, int[][] edges) {
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

    private List<List<Integer>> getSccBfs() {
        boolean[] discovered = new boolean[nVertices];
        List<List<Integer>> scc = new LinkedList<>();
        for (int i = 0; i < nVertices; i++) {
            if (!discovered[i]) {
                scc.add(bfs(i, discovered));
            }
        }
        return scc;
    }

    private List<Integer> bfs(int src, boolean[] discovered) {
        List<Integer> connected = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        discovered[src] = true;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            connected.add(u);
            for (int v : adjList.get(u)) {
                if (!discovered[v]) {
                    queue.add(v);
                    discovered[v] = true;
                }
            }
        }
        return connected;
    }

    private List<Integer> dfs(int src) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> trav = new LinkedList<>();
        boolean[] explored = new boolean[nVertices];
        int[] parent = new int[nVertices];
        Arrays.fill(parent, -1);
        stack.push(src);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (explored[u]) {
                continue;
            }
            explored[u] = true;
            trav.add(u);
            for (int v : adjList.get(u)) {
                if (explored[v]) {
                    continue;
                }
                stack.push(v);
                parent[v] = u;
            }
        }
        return trav;
    }


    int time = 0;
    boolean[] discovered;
    boolean[] processed;
    int[] entryTime;
    int[] exitTime;
    int[] parent;

    private void initDfsWithTime() {
        time = 0;
        discovered = new boolean[nVertices];
        processed = new boolean[nVertices];
        entryTime = new int[nVertices];
        exitTime = new int[nVertices];
        parent = new int[nVertices];
        Arrays.fill(parent, -1);
    }

    private void dfsWithTime() {
        initDfsWithTime();
        for (int i = 0; i < nVertices; i++) {
            dfsWithTime(i);
        }
        printDfsWithTime();
    }

    private void printDfsWithTime() {
        for (int i = 0; i < nVertices; i++) {
            System.out.println(i + " entry:" + entryTime[i] + " exit:" + exitTime[i] + " parent:" + parent[i]);
        }
    }

    private void dfsWithTime(int u) {
        if (processed[u]) {
            return;
        }
        discovered[u] = true;
        time++;
        entryTime[u] = time;
        for (int v : adjList.get(u)) {
            if (!discovered[v]) {
                parent[v] = u;
                dfsWithTime(v);
            } else if (!processed[v]) {
                System.out.println("edge1:(" + u +", " + v + ")");
                if (parent[u] != v) {
                    System.out.println("cycle" + u + " " + v + " " + parent[u]);
                }
            }
        }
        time++;
        exitTime[u] = time;
        processed[u] = true;
    }



    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {3, 4},
                {4, 5}, {2, 4}, {2, 6}, {2, 7}, {6, 7}, {8, 9}, {10, 11}, {11, 12}};
        UnorderedGraph graph = new UnorderedGraph(13, edges);
        graph.getSccBfs();
        System.out.println(graph.dfs(0));
        graph.dfsWithTime();
    }
}
