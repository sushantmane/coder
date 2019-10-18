/**
 * Bubble Sort/Sinking Sort: compares adjacent elements and swaps them if they
 * are in the wrong order, until the list is sorted.
 * Analysis:
 * Space Complexity: O(1)
 * Time Complexity: O(n^2)
 *     Worst-case: O(n^2) comparisons and swaps - (array is reverse-ordered)
 *     Best-case: O(n) comparisons and O(1) swaps - (array is already sorted)
 *     Avg-case: O(n^2) comparisons and swaps
 */

package edu.sjsu.cs.cs255.sorting;


public class BubbleSort {

    void sort(int[] array) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}
