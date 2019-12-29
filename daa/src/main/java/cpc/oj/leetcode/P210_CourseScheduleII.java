package cpc.oj.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P210_CourseScheduleII {

    private CourseGraph graph;

    public int[] canFinish(int numCourses, int[][] prerequisites) {
        graph = new CourseGraph(numCourses, prerequisites);
        boolean[] explored = new boolean[graph.getV()];
        boolean[] processed = new boolean[graph.getV()];
        List<Integer> tsort = new LinkedList<>();
        for (int i = 0; i < graph.getV(); i++) {
            if (explored[i]) {
                continue;
            }
            if (dfs(i, explored, processed, tsort)) {
                return new int[0];
            }
        }
        Collections.reverse(tsort);
        int[] out = tsort.stream().mapToInt(Integer::intValue).toArray();
        return out;
    }

    private boolean dfs(int u, boolean[] explored, boolean[] processed, List<Integer> tsort) {
        explored[u] = true;
        for (int v : graph.getNeighbors(u)) {
            if (!explored[v]) {
                if (dfs(v, explored, processed, tsort)) {
                    return true;
                }
            } else if (!processed[v]) {
                System.out.println("Cycle: " + u + ", " + v);
                return true;
            }
        }
        processed[u] = true;
        tsort.add(u);
        return false;
    }
}