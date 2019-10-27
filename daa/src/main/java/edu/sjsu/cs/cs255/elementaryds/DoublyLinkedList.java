package edu.sjsu.cs.cs255.elementaryds;

public class DoublyLinkedList {

    private class ListNode {
        int key;
        ListNode prev;
        ListNode next;

        ListNode(int key) {
            this.key = key;
        }
    }

    private ListNode head = null;

    public void addAtTail(int val) {
        ListNode newEle = new ListNode(val);
        if (head == null) {
            head = newEle;
            return;
        }
        ListNode ptr;
        for (ptr = head; ptr.next != null; ptr = ptr.next) {
        }
        ptr.next = newEle;
        newEle.prev = ptr;
    }

    public void addAtHead(int val) {
        ListNode newEle = new ListNode(val);
        if (head == null) {
            head = newEle;
            return;
        }
        head.prev = newEle;
        newEle.next = head;
        head = newEle;
    }

    public void addAtIndex(int index, int val) {
        ListNode newEle = new ListNode(val);
        int i = 0;
        boolean found = false;
        ListNode ptr;
        for (ptr = head; ptr.next != null; ptr = ptr.next) {
            if (i == index - 1) {
                found = true;
                break;
            }
            i++;
        }
        if (!found) {
            return;
        }
        newEle.prev = ptr;
        newEle.next = ptr.next;
        newEle.next.prev = newEle;
    }

    public int get(int index) {
        int i = 0;
        ListNode ptr;
        for (ptr = head; ptr.next != null; ptr = ptr.next) {
            if (i == index) {
                return ptr.key;
            }
            i++;
        }
        return -1;
    }

    public void print() {
        for (ListNode ptr = head; ptr != null; ptr = ptr.next) {
            System.out.print(ptr.prev == null ? " NIL " : ptr.prev.key + " ");
            System.out.print(ptr.key + " ");
            System.out.print(ptr.next == null ? " NIL " : ptr.next.key + " ");
            System.out.println();
        }
        System.out.println();
    }
}
