package cpc.oj.leetcode;

public class P21_MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null && head2 != null) {
            return head2;
        }

        if (head1 != null && head2 == null) {
            return head1;
        }

        if (head1.val <= head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }
}
