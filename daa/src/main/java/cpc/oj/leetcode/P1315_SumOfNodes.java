package cpc.oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1315_SumOfNodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calculateSum(root, false, false);
    }

    private int calculateSum(TreeNode root, boolean grandParent, boolean parent) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (grandParent) {
            sum += root.val;
        }
        grandParent = parent;
        parent = root.val % 2 == 0 ? true : false;
        sum += calculateSum(root.left, grandParent, parent);
        sum += calculateSum(root.right, grandParent, parent);
        return sum;
    }

//    public int sumEvenGrandparent(TreeNode root) {
////        calculateSum(root, 0);
////        return sum;
////    }
////
////    int sum = 0;
////    List<Boolean> evens = new ArrayList<>();
////    private void calculateSum(TreeNode root, int i) {
////        if (root == null) {
////            return;
////        }
////        int val = root.val;
////        if (val % 2 == 0) {
////            evens.add(i, true);
////        } else {
////            evens.add(i, false);
////        }
////        if (i - 2 >= 0 && evens.get(i - 2)) {
////            sum += val;
////        }
////        i++;
////        calculateSum(root.left, i);
////        calculateSum(root.right, i);
////    }
}