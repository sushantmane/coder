package edu.sjsu.cs.cs255.sorting;


public class SelectionSort {

    void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int idxOfMv = i;
            boolean mvExists = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[idxOfMv]) {
                    idxOfMv = j;
                    mvExists = true;
                }
            }
            if (mvExists) {
                int tmp = array[i];
                array[i] = array[idxOfMv];
                array[idxOfMv] = tmp;
            }
        }
    }
}
