package edu.sjsu.cs.cs255.revision;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int v) {
            val = v;
        }
    }

    TreeNode root = null;

    public BST() {

    }

    void add(int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode ptr = root;

        while (true) {
            if (val < ptr.val) {
                if (ptr.left == null) {
                    ptr.left = newNode;
                    return;
                }
                ptr = ptr.left;
            } else {
                if (ptr.right == null) {
                    ptr.right = newNode;
                    return;
                }
                ptr = ptr.right;
            }
        }
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void bfs() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode ptr;
        while (queue.size() != 0) {
            ptr = queue.poll();
            if (ptr.left != null) {
                queue.add(ptr.left);
            }
            if (ptr.right != null) {
                queue.add(ptr.right);
            }
            System.out.print(ptr.val + " ");
        }
    }

    void print() {
        System.out.println("preOrder: ");
        preOrder(root);
        System.out.println();

        System.out.println("inOrder: ");
        inOrder(root);
        System.out.println();

        System.out.println("postOrder: ");
        postOrder(root);
        System.out.println();

        System.out.println("bfs: ");
        bfs();
        System.out.println();
    }

    TreeNode getSuccessor(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode ptr = root;
        TreeNode parent = root;
        while (ptr.left != null) {
            parent = ptr;
            ptr = ptr.left;
        }
        if (parent == ptr) {
            return root;
        }
        parent.left = ptr.right;
        return ptr;
    }

    boolean delete(int val) {
        if (root == null) {
            return false;
        }

        TreeNode ptr = root;
        TreeNode parent = root;

        while (ptr != null && ptr.val != val) {
            parent = ptr;
            if (ptr.val > val) {
                ptr = ptr.left;
            } else {
                ptr = ptr.right;
            }
        }

        if (ptr == null) {
            return false;
        }

        boolean left = (ptr == parent.left);
        TreeNode succNode = null;
        if (ptr.left == null && ptr.right == null) {
            succNode = null;
        } else if (ptr.left == null) {
            succNode = ptr.right;
        } else if (ptr.right == null) {
            succNode = ptr.left;
        } else {
            succNode = getSuccessor(ptr.right);
            succNode.left = ptr.left;
            succNode.right = ptr.right;
            System.out.println("successor of " + val + " " + succNode.val);
        }
        if (left) {
            parent.left = succNode;
            System.out.println("parent.left: " + parent.val + " sn: " + succNode.val);
        } else {
            parent.right = succNode;
            System.out.println("parent.right: " + parent.val + " sn: " + succNode.val);
        }

        if (ptr == root) {
            root = succNode;
        }

        return true;
    }


    void inOrderIter() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        System.out.println("Iterative inorder...");

        TreeNode ptr = root;
        int i = 0;
        List<Integer> t = new LinkedList<>();
        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }

            ptr = stack.pop();
            t.add(ptr.val);
            ptr = ptr.right;
        }

        System.out.println(t);
    }

    void print(Stack<TreeNode> stack) {
        List<TreeNode> list = new LinkedList<>(stack);
        for (TreeNode n : list) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }

    void preOrder() {

    }

    void postOrder() {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;
        System.out.println("Iterative postorder...");

        Set<TreeNode> set =  new HashSet<>();

        int i = 0;
        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }

            ptr = stack.pop();

            if (ptr.right == null || set.contains(ptr.right)) {
                set.add(ptr);
                res.add(ptr.val);
                ptr = null;
            } else {
                stack.push(ptr);
                ptr = ptr.right;
            }

            if (i++ == 20) {
                break;
            }
            print(stack);
        }
        System.out.println(res);
    }


    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = {5, 4, 9, 3, 7, 6, 8, 15, 12, 16, 10, 11};
        for (int n : arr) {
            bst.add(n);
        }

//        bst.print();
//        System.out.println(bst.delete(5));
        System.out.println("-----");
        bst.print();
        bst.inOrderIter();
        bst.postOrder();
    }
}
/*
                5
         4               9
       3             7          15
                   6   8      12   16
                            10
                               11

 3 4 6 8 7 11 10 12 16 15 9 5
 */

/*

private TreeNode rightRotate(TreeNode gp) {
        TreeNode tmp = gp.left;
        gp.left = tmp.right;
        tmp.right = gp;

        if (gp.left != null) {
            gp.left.parent = gp;
        }

        TreeNode ggp = gp.parent;
        tmp.parent = gp.parent;
        gp.parent = tmp;

        if (ggp == null) {
            return tmp;
        }
        if (gp == ggp.left) {
            ggp.left = tmp;
        } else {
            ggp.right = tmp;
        }
        return tmp;
    }

    private TreeNode leftRotate(TreeNode gp) {
        TreeNode tmp = gp.right;
        gp.right = tmp.left;
        tmp.left = gp;

        if (gp.right != null) {
            gp.right.parent = gp;
        }

        TreeNode ggp = gp.parent;
        gp.parent = tmp;
        tmp.parent = ggp;

        if (ggp == null) {
            return tmp;
        }

        if (gp == ggp.left) {
            ggp.left = tmp;
        } else {
            ggp.right = tmp;
        }

        return tmp;
    }


 */