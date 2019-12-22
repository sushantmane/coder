package edu.sjsu.cs.cs255.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SimpleGraph {

    static class Vertex implements Comparable<Vertex> {

        String label;

        public Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Vertex)) {
                return false;
            }
            Vertex vertex = (Vertex) o;
            return this.label.equals(vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(label);
        }

        @Override
        public String toString() {
            return label;
        }

        @Override
        public int compareTo(Vertex v) {
            return label.compareTo(v.label);
        }
    }

    private Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    private void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    private void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(v);
    }

    private void addEdge(String labelU, String labelV) {
        Vertex u = new Vertex(labelU);
        Vertex v = new Vertex(labelV);
        adjVertices.get(u).add(v);
        adjVertices.get(v).add(u);
    }

    private void removeEdge(String labelU, String labelV) {
        Vertex u = new Vertex(labelU);
        Vertex v = new Vertex(labelV);
        adjVertices.get(u).remove(v);
        adjVertices.get(v).remove(u);
    }

    public void dfs(String root) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(new Vertex(root));
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            if (visited.contains(vertex)) {
                continue;
            }
            visited.add(vertex);
            stack.addAll(adjVertices.get(vertex));
        }
        System.out.println("order" + visited);
    }

    public void bfs(String root) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(root));
        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            if (visited.contains(vertex)) {
                continue;
            }
            visited.add(vertex);
            queue.addAll(adjVertices.get(vertex));
            System.out.println(queue + " : " + visited);
        }
        System.out.println(visited);
    }

    public static void main(String[] args) {
        SimpleGraph graph = new SimpleGraph();
        graph.addVertex("a");
        graph.addVertex("b");
        graph.addVertex("c");
        graph.addVertex("d");
        graph.addVertex("e");
        graph.addEdge("a", "b");
        graph.addEdge("a", "c");
        graph.addEdge("a", "d");
        graph.addEdge("b", "c");
        graph.addEdge("b", "d");
        graph.addEdge("b", "e");
        graph.addEdge("c", "d");
        graph.addEdge("d", "e");
        System.out.println(graph);

        graph.bfs("a");
    }

    @Override
    public String toString() {
        return "SimpleGraph{" +
                "adjVertices=" + adjVertices +
                '}';
    }
}
