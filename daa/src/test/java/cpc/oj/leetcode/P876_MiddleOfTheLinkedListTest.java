package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P876_MiddleOfTheLinkedListTest {

    @Test
    void middleNode() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        P876_MiddleOfTheLinkedList.ListNode l1 = P876_MiddleOfTheLinkedList.createList(arr, 0);
        P876_MiddleOfTheLinkedList.printList(l1);

        P876_MiddleOfTheLinkedList.middleNode(l1);
    }
}