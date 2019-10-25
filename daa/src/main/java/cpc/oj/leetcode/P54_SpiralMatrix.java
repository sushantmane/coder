package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P54_SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int n = row * col;
        int i = 0;
        int j = 0;
        int layer = 0;
        while (list.size() < n) {
            for (i = layer, j = layer; j < (col - layer); j++) {
                list.add(matrix[i][j]);
            }
            if (list.size() == n) {
                break;
            }
            for (++i, --j; i < (row - layer); i++) {
                list.add(matrix[i][j]);
            }
            if (list.size() == n) {
                break;
            }
            for (--i, --j; j > layer; j--) {
                list.add(matrix[i][j]);
            }
            if (list.size() == n) {
                break;
            }
            for (; i > layer && j >= layer; i--) {
                list.add(matrix[i][j]);
            }
            layer++;
        }
        return list;
    }
}
