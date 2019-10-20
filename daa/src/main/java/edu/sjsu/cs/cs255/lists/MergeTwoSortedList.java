package edu.sjsu.cs.cs255.lists;

public class MergeTwoSortedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node createList(int[] nums, int i) {
        if (i >= nums.length) {
            return null;
        }
        Node node = new Node(nums[i]);
        node.next = createList(nums, ++i);
        return node;
    }

    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        printList(head.next);
    }

    public static Node merge(Node head1, Node head2) {

        if (head1 == null && head2 != null) {
            return head2;
        }

        if (head1 != null && head2 == null) {
            return head1;
        }

        if (head1.val <= head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
}
