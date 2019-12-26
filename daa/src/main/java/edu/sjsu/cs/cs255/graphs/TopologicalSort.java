package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    Map<Integer, List<Integer>> adjList = new LinkedHashMap<>();

    void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        adjList.get(u).add(v);
    }

    void addVertices(int n) {
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        addVertices(numCourses);
        for (int[] preq : prerequisites) {
            addEdge(preq);
        }
        System.out.println(adjList);
        return true;
    }

    private boolean isDag(int start, Set<Integer> processed) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new LinkedHashSet<>();
        //List<Integer> notProcessed = new LinkedList<>(adjList.keySet());
        stack.push(start);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (visited.contains(u)) {
                System.out.println("v:" + visited + " u:" + u + " v:" + start);
                return false;
            }
            visited.add(u);
            //notProcessed.remove(new Integer(u));
            for (int v : adjList.get(u)) {
                stack.push(v);
            }
            //if (stack.isEmpty() && !notProcessed.isEmpty()) {
            //    stack.push(notProcessed.get(0));
            //}
        }
        processed.addAll(visited);
        Set<Integer> nodes = new LinkedHashSet<>(adjList.keySet());
        nodes.removeAll(processed);
        if (nodes.isEmpty()) {
           return true;
        }
        System.out.println("visited:"+ visited + " p:" + processed + " nP:" + nodes.toArray()[0] + " aL:" + adjList);
        return isDag((Integer) nodes.toArray()[0], processed);
    }

    public boolean isDag(int n) {
        return isDag(n, new LinkedHashSet<>());
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        int[][] preqs = {{1,0}, {2, 1}, {2, 0}};
        ts.canFinish(3, preqs);
        System.out.println(ts.isDag(0));
    }
}
