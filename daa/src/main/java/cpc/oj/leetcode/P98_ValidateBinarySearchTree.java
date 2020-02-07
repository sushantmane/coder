package cpc.oj.leetcode;

public class P98_ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // public boolean isValidBST(TreeNode root) {
    //        List<Integer> list = new ArrayList<>();
    //        isValidBST(root, list);
    //        return isIncreasing(list);
    //    }
    //
    //    private void isValidBST(TreeNode root,  List<Integer> list) {
    //        if (root == null) {
    //            return;
    //        }
    //        isValidBST(root.left, list);
    //        list.add(root.val);
    //        isValidBST(root.right, list);
    //    }
    //
    //    private boolean isIncreasing(List<Integer> list) {
    //        for (int i = 1; i < list.size(); i++) {
    //            if (list.get(i) <= list.get(i - 1)) {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ((root.left != null && root.left.val >= root.val)
                || (root.right != null && root.right.val <= root.val)) {
            return false;
        }
        return isValidBST(root.left, root.val) && isValidBST(root.right, root.val);
    }

    private boolean isValidBST(TreeNode root, int parent) {
        if (root == null) {
            return true;
        }
        boolean res = true;
        if (root.left != null) {
            if ((root.left.val < root.val) && ((parent < root.val && root.left.val > parent) || parent > root.val)) {
                res = isValidBST(root.left, parent);
            } else {
                res = false;
            }
        }
        if (!res) {
            return false;
        }
        if (root.right != null) {
            if ((root.right.val > root.val) && ((parent > root.val && root.right.val < parent) || parent < root.val)) {
                res = isValidBST(root.right, parent);
            } else {
                res = false;
            }
        }
        return res;
    }
}
