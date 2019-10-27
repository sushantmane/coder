package edu.sjsu.cs.cs255.elementaryds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void addNode() {
        int[] elements = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        DoublyLinkedList list = new DoublyLinkedList();
        for (int ele : elements) {
            list.addAtTail(ele);
        }
        list.print();

        for (int ele : elements) {
            list.addAtHead(ele);
        }

        list.addAtIndex(2, 99);
        list.print();
    }

    @Test
    void print() {
    }
}