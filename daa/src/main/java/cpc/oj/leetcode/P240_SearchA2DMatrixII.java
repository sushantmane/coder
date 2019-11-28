package cpc.oj.leetcode;

public class P240_SearchA2DMatrixII {

    private int binarySearch(int[] mat, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mat[mid] > key) {
                high = mid - 1;
            }
            if (mat[mid] < key) {
                low = mid + 1;
            }
            if (mat[mid] == key) {
                return mid - 1;
            }
        }
        return low - 1;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int startIdx = 0;
        int endIdx = n - 1;
        for (int[] rowMat : matrix) {
            if (rowMat[startIdx] > target) {
                return false;
            }
            if (rowMat[endIdx] < target) {
                continue;
            }
            int pos = binarySearch(rowMat, startIdx, endIdx, target);
            if (rowMat[pos + 1] == target) {
                return true;
            }
            if (rowMat[pos + 1] > target) {
                endIdx = pos + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P240_SearchA2DMatrixII obj = new P240_SearchA2DMatrixII();
        int[][] mat = {{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(obj.searchMatrix(mat, 20));
    }
}
