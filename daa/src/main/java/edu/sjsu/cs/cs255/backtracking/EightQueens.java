package edu.sjsu.cs.cs255.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class EightQueens {

    private static boolean isLegalMove(Integer[] positions, int row, int col) {
//        System.out.print(row + " " + col + ": ");
//        Arrays.stream(positions).forEach(pos -> System.out.print(pos + " "));
//        System.out.println();

        // should not share a column with other queens
        for (int i = 0; i < positions.length; i++) {
            if (i != row && positions[i] == col) {
                return false;
            }
        }
        int c = 1;
        for (int i = row - 1; i >= 0; i--) {
            if (positions[i] == (col - c) || positions[i] == (col + c)) {
                return false;
            }
            c++;
        }

        c = 1;
        for (int i = row + 1; i < positions.length; i++) {
            if (positions[i] != - 1 && (positions[i] == (col - c) || positions[i] == (col + c))) {
                System.out.println("da fuck!");

                System.out.println("row:" + row + " col:" + col + " c:" + c + " p[i]:" + positions[i]);
                Arrays.stream(positions).forEach(pos -> System.out.print(pos + " "));
                System.out.println();

                return false;
            }
            c++;
        }

        return true;
    }

    private static Set<Integer> getCandidates(Integer[] positions) {
        Set<Integer> candidates = new LinkedHashSet<>();
        Set<Integer> occupied = new HashSet<>();
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] != -1) {
                occupied.add(positions[i]);
            }
        }
        for (int i = 0; i < positions.length; i++) {
            if (!occupied.contains(i)) {
                candidates.add(i);
            }
        }
        return candidates;
    }

    static void backtrack(Integer[] positions, int n, int k, List<List<Integer>> res) {
        if (k == n) {
            res.add(Arrays.asList(positions));
            // check if legal move
            System.out.println("solution:");
            Arrays.stream(positions).forEach(pos -> System.out.print(pos + " "));
            System.out.println();
            return;
        }
        Set<Integer> candidates = getCandidates(positions);
//        System.out.println("Candidates for row:" + k + " - " + candidates);
        for (int pos : candidates) {
            // make a move
            positions[k] = pos;
            if (!isLegalMove(positions, k, pos)) {
                positions[k] = -1;
                continue;
            }
            backtrack(positions, n, k + 1, res);
            // undo a move
            positions[k] = -1;
        }
    }

    public static void findNQueensPositions(int n) {
        List<List<Integer>> res = new LinkedList<>();
        Integer[] positions = new Integer[n];
        Arrays.fill(positions, -1);
        backtrack(positions, n, 0, res);
        System.out.println(res.size() + " <== total solutions");
    }

    public static void main(String[] args) {
        findNQueensPositions(8);
    }
}
