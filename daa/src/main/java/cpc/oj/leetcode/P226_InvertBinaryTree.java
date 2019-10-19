package cpc.oj.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P226_InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode createBT(int[] nums) {
        TreeNode root = null;
        Queue<TreeNode> queue = new LinkedList<>();
        int turn = 0;
        for (int i : nums) {
            TreeNode newNode = new TreeNode(i);
            if (root == null) {
                root = newNode;
                queue.add(root);
            } else {
                // left
                if (turn == 0) {
                    TreeNode node = queue.peek();
                    node.left = newNode;
                    turn = 1;
                    queue.add(newNode);
                } else {
                    TreeNode node = queue.poll();
                    node.right = newNode;
                    turn = 0;
                    queue.add(newNode);
                }
            }
        }
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void inorder1(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        inorder1(root.left, list);
        list.add(root.val);
        inorder1(root.right, list);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() != 0) {
            TreeNode curr = queue.poll();
            if (curr.right != null) {
                queue.add(curr.right);
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
        }

        return root;
    }
}
