package edu.sjsu.cs.cs255.sorting;


public class InsertionSort {

    void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    continue;
                }
                break;
            }
        }
    }
}
