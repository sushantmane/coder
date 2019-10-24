package cpc.oj.leetcode;

import java.util.List;
import java.util.Stack;

public class P445_AddTwoNumbersII {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = reverseList(head.next);
        node.next = head;
        // TODO

        return null;
    }

     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverseList(l1);
     }

    public ListNode createList(int[] arr, int i) {
        if (i == arr.length) {
            return null;
        }
        ListNode node = new ListNode(arr[i]);
        node.next = createList(arr, ++i);
        return node;
    }

    public void printList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        printList(head.next);
    }
}
