package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

class P138_CopyListWithRandomPointerTest {

    @Test
    void createList() {
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        P138_CopyListWithRandomPointer obj = new P138_CopyListWithRandomPointer();
        P138_CopyListWithRandomPointer.Node root = obj.createList(arr);
        obj.printList(root);
    }

    @Test
    void copyRandomList() {
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        P138_CopyListWithRandomPointer obj = new P138_CopyListWithRandomPointer();
        P138_CopyListWithRandomPointer.Node headO = obj.createList(arr);
        obj.printList(headO);
        P138_CopyListWithRandomPointer.Node headD = obj.copyRandomList(headO);
        obj.printList(headD);
    }

    @Test
    void copyRandomListRecursiveTest() {
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        P138_CopyListWithRandomPointer obj = new P138_CopyListWithRandomPointer();
        P138_CopyListWithRandomPointer.Node headO = obj.createList(arr);
        obj.printList(headO);
        P138_CopyListWithRandomPointer.Node headD = obj.copyRandomListRecursive(headO);
        obj.printList(headD);
    }
 }