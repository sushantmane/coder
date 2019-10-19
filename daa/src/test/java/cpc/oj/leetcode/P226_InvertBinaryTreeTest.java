package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P226_InvertBinaryTreeTest {

    @Test
    void invertTree() {
        int[] arr = {1, 5, 2, 6, 4, 9, 3};
        Integer[] exp = {3, 2, 9, 1, 4, 5, 6};
        List<Integer> listPre = Arrays.asList(exp);
        P226_InvertBinaryTree.TreeNode tn = P226_InvertBinaryTree.createBT(arr);
        P226_InvertBinaryTree.invertTree(tn);
        List<Integer> listPost = new ArrayList<>();
        P226_InvertBinaryTree.inorder1(tn, listPost);
        assertEquals(listPre, listPost);
    }

    @Test
    void invertTree_Empty() {
        int[] arr = {};
        Integer[] exp = {};
        List<Integer> listPre = Arrays.asList(exp);
        P226_InvertBinaryTree.TreeNode tn = P226_InvertBinaryTree.createBT(arr);
        P226_InvertBinaryTree.invertTree(tn);
        List<Integer> listPost = new ArrayList<>();
        P226_InvertBinaryTree.inorder1(tn, listPost);
        assertEquals(listPre, listPost);
    }
}