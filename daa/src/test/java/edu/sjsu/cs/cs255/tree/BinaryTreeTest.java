package edu.sjsu.cs.cs255.tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    @DisplayName("Create complete binary tree from an array using recursive method")
    void create_Recursive() {
        int[] arr = {1, 5, 2, 6, 4, 9, 3};
        BinaryTree bt = new BinaryTree(arr);
        bt.inorder();
        bt.bfsTraversal();
    }

    @Test
    @DisplayName("Create complete binary tree from an array using iterative method")
    void createCBT_Iterative() {
        int[] arr = {1, 5, 2, 6, 4, 9, 3};
        BinaryTree bt = new BinaryTree();
        bt.createCBT(arr);
        bt.inorder();
        bt.bfsTraversal();
    }
}