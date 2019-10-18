package edu.sjsu.cs.cs255.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testQuickSort() {
        int[] arr = {10, 80, 3, 30, 90, 40, 6, 5, 9, 4, 9, 7, 50, 5, 10, 2, 70};
        Arrays.stream(arr).forEach(key -> System.out.print(key + " "));
        System.out.println();
        QuickSort.sort(arr, 0, arr.length - 1);
    }

}