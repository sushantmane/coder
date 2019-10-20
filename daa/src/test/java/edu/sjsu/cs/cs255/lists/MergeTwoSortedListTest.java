package edu.sjsu.cs.cs255.lists;

import org.junit.jupiter.api.Test;


class MergeTwoSortedListTest {

    @Test
    void createList() {
        int[] arr_1 = {11, 22, 33, 40, 44, 55, 66, 77, 88, 99};
        MergeTwoSortedList.Node head_1 = MergeTwoSortedList.createList(arr_1, 0);
        MergeTwoSortedList.printList(head_1);

        System.out.println();

        int[] arr_2 = {13, 14, 20, 33, 65, 67, 78, 90, 92, 95, 99, 100, 104, 120};
        MergeTwoSortedList.Node head_2 = MergeTwoSortedList.createList(arr_2, 0);
        MergeTwoSortedList.printList(head_2);

        System.out.println();

        MergeTwoSortedList.Node head3 = MergeTwoSortedList.merge(head_1, head_2);

        System.out.println();
        MergeTwoSortedList.printList(head3);
    }
}