package cpc.oj.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P297_SerializeAndDeserializeBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        int expDepth = maxDepth(root);
        int maxE = (1 << expDepth) - 1;
        String[] a = new String[maxE];
        Arrays.fill(a, "null");
        serialize(root, 0, a);
        int i = 0;
        for ( i = a.length - 1; i >= 0; i--) {
            if ("null".equals(a[i])) {
                continue;
            }
            break;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <= i; j++) {
            sb.append(a[j]).append(" ");
        }
        return sb.toString();
    }

    private static void serialize(TreeNode treeNode, int i, String[] arr) {
        if (treeNode == null) {
            return;
        }
        arr[i] = String.valueOf(treeNode.val);
        serialize(treeNode.left, 2 * i + 1, arr);
        serialize(treeNode.right, 2 * i + 2, arr);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        return createBinaryTree(arr, 0);
    }

    private static TreeNode createBinaryTree(String[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        if (arr[i].equalsIgnoreCase("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(arr[i]));
        treeNode.left = createBinaryTree(arr, 2 * i + 1);
        treeNode.right = createBinaryTree(arr, 2 * i + 2);
        return treeNode;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
