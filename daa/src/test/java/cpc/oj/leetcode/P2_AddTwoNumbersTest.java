package cpc.oj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P2_AddTwoNumbersTest {

    @Test
    void addTwoNumbers() {
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};

        P2_AddTwoNumbers.ListNode l1 = P2_AddTwoNumbers.createList(arr1, 0);
        P2_AddTwoNumbers.printList(l1);
        P2_AddTwoNumbers.ListNode l2 = P2_AddTwoNumbers.createList(arr2, 0);
        P2_AddTwoNumbers.printList(l2);

        System.out.println("--");
        P2_AddTwoNumbers.ListNode l3 = P2_AddTwoNumbers.addTwoNumbers(l1, l2);
        P2_AddTwoNumbers.printList(l3);
    }
}