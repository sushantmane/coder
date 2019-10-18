package edu.sjsu.cs.cs255.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void simpleTest() {
        LinkedList<Integer> list = new LinkedList();
        list.insert(12);
        list.insert(13);
        list.insert(14);
        list.insert(15);
        list.insert(16);
        list.traverse();
    }

}