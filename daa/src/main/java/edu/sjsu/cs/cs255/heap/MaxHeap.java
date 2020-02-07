package edu.sjsu.cs.cs255.heap;

import java.util.Arrays;

public class MaxHeap {

    private static void maxHeapify(int[] arr, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < arr.length && arr[l] > arr[i]) {
            largest = l;
        }
        if (r < arr.length && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest == i) {
            return;
        }
        int t = arr[i];
        arr[i] = arr[largest];
        arr[largest] = t;
        maxHeapify(arr, largest);
    }

    private static int[] build(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        build(arr);
        Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
        System.out.println();
    }
}
