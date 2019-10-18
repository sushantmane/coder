package edu.sjsu.cs.cs255.sorting;


import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int piv = begin;
        int i = begin;
        int j = end;

        while (i <= j) {
            if (arr[i] > arr[piv] && arr[j] < arr[piv]) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            if (arr[i] <= arr[piv]) {
                i++;
            }
            if (arr[j] >= arr[piv]) {
                j--;
            }
        }
        int tmp = arr[j];
        arr[j] = arr[piv];
        arr[piv] = tmp;
        Arrays.stream(arr).forEach(key -> System.out.print(key + " "));
        System.out.println();

        sort(arr, begin, j - 1);
        sort(arr, j + 1, end);
    }
}