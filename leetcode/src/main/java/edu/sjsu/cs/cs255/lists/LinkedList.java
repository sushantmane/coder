package edu.sjsu.cs.cs255.lists;


class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList<T> {

    Node root = null;

    void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Node ptr = root;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    void traverse() {
        Node ptr = root;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
