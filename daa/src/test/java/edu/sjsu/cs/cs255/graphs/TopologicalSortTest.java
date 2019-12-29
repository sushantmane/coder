package edu.sjsu.cs.cs255.graphs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void simpleTest() {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {1, 4}, {3, 4},
                {4, 5}, {2, 4}, {2, 6}, {2, 7}, {6, 7}, {8, 9}, {10, 11}, {11, 12}};
        int nVertices = 13;
        Graph graph = new Graph(nVertices, edges, true);
        TopologicalSort.sort(graph);
    }

    @Test
    public void simpleTest_2() {
        int[][] edges = {{0, 3}, {0, 4}, {0, 6},
                {1, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {3, 4},
                {4, 5}, {4, 6}, {5, 6}};
        int nVertices = 7;
        Graph graph = new Graph(nVertices, edges, true);
        System.out.println(graph);
        TopologicalSort.sort(graph);
    }
}