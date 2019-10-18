package edu.sjsu.cs.cs255.arrays;

public class SpiralMatrix {

    public static int[][] spiralMatrix(int n) {
        int[][] res = new int[n][n];
        int v = 1;
        int layer = 0;
        int i = 0;
        int j = 0;
        int limit = n * n;
        while (v <= limit) {
            i = layer;
            j = layer;
            while (j < n - layer) {
                res[i][j] = v++;
                j++;
            }
            j--;
            i++;
            while (i < n - layer) {
                res[i][j] = v++;
                i++;
            }
            i--;
            j--;
            while (j > layer) {
                res[i][j] = v++;
                j--;
            }
            while (i > layer) {
                res[i][j] = v++;
                i--;
            }
            layer++;
        }
        return res;
    }
}
