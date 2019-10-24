package cpc.oj.leetcode;

import java.util.List;

public class P876_MiddleOfTheLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode createList(int[] arr, int i) {
        if (i == arr.length) {
            return null;
        }
        ListNode node = new ListNode(arr[i]);
        node.next = createList(arr, ++i);
        return node;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        printList(head.next);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fPtr;
        ListNode aPtr;
        for (aPtr = head, fPtr = head; aPtr != null && aPtr.next != null;) {
            fPtr = fPtr.next;
            aPtr = aPtr.next.next;
        }
        return fPtr;
    }
}