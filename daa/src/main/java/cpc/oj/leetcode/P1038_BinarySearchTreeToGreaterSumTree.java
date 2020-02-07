package cpc.oj.leetcode;

public class P1038_BinarySearchTreeToGreaterSumTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        updateTree(root, 0);
        return root;
    }

    private int updateTree(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        root.val = updateTree(root.right, sum) + root.val;
        return updateTree(root.left, root.val);
    }
}
