package edu.sjsu.cs.cs255.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class InsertionSortTest {

    InsertionSort srt;

    @BeforeEach
    public void setup() {
        srt = new InsertionSort();
    }

    @Test
    void sort_ReverseOrderedTest() {
        // reverse-ordered collection
        int[] input_0 = {105, 95, 85, 75, 75, 65, 55, 45, 35, 25, 15, 5, 0};
        srt.sort(input_0);
        Arrays.stream(input_0).forEach(x -> System.out.print(x + " "));
    }

    @Test
    void sort_SortedTest() {
        // sorted collection
        int[] input_1 = {0, 5, 15, 25, 35, 45, 55, 65, 75, 85, 95, 105};
        srt.sort(input_1);
        Arrays.stream(input_1).forEach(x -> System.out.print(x + " "));
    }

    @Test
    void sort_RandomOrderedTest() {
        // sorted collection
        int[] input_2 = {45, 15, 25, 5, 35, 95, 0, 65, 75, 105, 85, 55};
        srt.sort(input_2);
        Arrays.stream(input_2).forEach(x -> System.out.print(x + " "));
    }
}