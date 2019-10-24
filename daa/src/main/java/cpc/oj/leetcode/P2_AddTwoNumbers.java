package cpc.oj.leetcode;

public class P2_AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode createList(int[] arr, int i) {
        if (i >= arr.length) {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        int sum = 0;
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        if (l1 == null && l2 == null && carry != 0) {
            sum = carry;
        }

        if (l1 == null && l2 != null) {
            sum = l2.val + carry;
        }

        if (l1 != null && l2 == null) {
            sum = l1.val + carry;
        }

        if (l1 != null &&  l2 != null) {
            sum = l1.val + l2.val + carry;
        }

        int val = sum % 10;
        carry = sum / 10;
        ListNode node = new ListNode(val);
        if (l1 == null && l2 != null) {
            node.next = addTwoNumbers(null, l2.next, carry);
        } else if (l1 != null && l2 == null) {
            node.next = addTwoNumbers(l1.next, null, carry);
        } else if (l1 != null && l2 != null){
            node.next = addTwoNumbers(l1.next, l2.next, carry);
        } else {
            node.next = addTwoNumbers(null, null, carry);
        }
        return node;
    }
}