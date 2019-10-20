package cpc.oj.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class P138_CopyListWithRandomPointer {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node createList(int[] nums) {
        Node head = null;
        Node ptr = null;
        for (int i : nums) {
            Node node = new Node(i, null, null);
            if (head == null) {
                head = node;
                ptr = head;
                continue;
            }
            ptr.next = node;
            ptr = ptr.next;
        }
        return head;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> mapOldToNew = new LinkedHashMap<>();
        Node tmp = head;
        while (tmp != null) {
            Node node = new Node(tmp.val, null, null);
            mapOldToNew.put(tmp, node);
            tmp = tmp.next;
        }
        for (Node old : mapOldToNew.keySet()) {
            Node copy = mapOldToNew.get(old);
            if (old.next != null) {
                copy.next = mapOldToNew.get(old.next);
            }
            if (old.random != null) {
                copy.random = mapOldToNew.get(old.random);
            }
        }
        return (Node) mapOldToNew.values().toArray()[0];
    }

    // recursive solution
    Map<Node, Node> mapOldToNew = new HashMap<>();
    public Node copyRandomListRecursive(Node head) {
        if (head == null) {
            return null;
        }
        Node copy = new Node(head.val, null, null);
        mapOldToNew.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = mapOldToNew.get(head.random);
        return copy;
    }

    public void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
