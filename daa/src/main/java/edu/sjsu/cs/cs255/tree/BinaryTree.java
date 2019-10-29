package edu.sjsu.cs.cs255.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode root = null;

    public BinaryTree(int[] nums) {
        root = create(nums, 0);
    }

    // recursive implementation of a complete binary tree
    // for a complete binary tree:
    //     2 * i + 1 --> left node
    //     2 * i + 2 --> right node
    private final TreeNode create(int[] nums, int i) {
        if (i >= nums.length) {
            return null;
        }
        TreeNode tNode = new TreeNode(nums[i]);
        tNode.left = create(nums, 2 * i + 1);
        tNode.right = create(nums, 2 * i + 2);
        return tNode;
    }

    public BinaryTree() {
    }

    // iterative implementation of a complete binary tree
    public void createCBT(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        short turn = 0; // 0 -- left; 1 -- right
        for (int i = 0; i < nums.length; i++) {
            TreeNode tNewNode = new TreeNode(nums[i]);
            if (root == null) {
                root = tNewNode;
            } else if (turn == 0) {
                TreeNode parent = queue.peek();
                parent.left = tNewNode;
                turn = 1;
            } else {
                TreeNode parent = queue.poll();
                parent.right = tNewNode;
                turn = 0;
            }
            queue.offer(tNewNode);
        }
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void bfsTraversal() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        System.out.println();
    }
}
