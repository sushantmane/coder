package cpc.oj.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        for (ListNode ptr = head; ptr != null; ptr = ptr.next) {
            if (set.contains(ptr)) {
                return ptr;
            }
            set.add(ptr);
        }

        return null;
    }

    public ListNode detectCycleFastSlowPtr(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode start = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                while (start != fastPtr) {
                    start = start.next;
                    fastPtr = fastPtr.next;
                }
                return fastPtr;
            }
        }
        return null;
    }
}
