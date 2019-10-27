package cpc.oj.leetcode;

public class P707_DesignLinkedList {

}

class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int i = 0;
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            if (i == index) {
                return ptr.val;
            }
            i++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index <= 0) {
            node.next = head;
            head = node;
            return;
        }
        int i = 0;
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            if (i + 1 == index) {
                node.next = ptr.next;
                ptr.next = node;
                return;
            }
            i++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        int i = 0;
        for (Node ptr = head; ptr.next != null; ptr = ptr.next) {
            if (i + 1 == index) {
                ptr.next = ptr.next.next;
                return;
            }
            i++;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            str.append(ptr.val + " ");
        }
        return str.toString();
    }
}
