package edu.sjsu.cs.cs255.heap;

import java.util.Arrays;

public class HeapSort {

    private static void maxHeapify(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < heapSize && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < heapSize && arr[largest] < arr[right]) {
            largest = right;
        }
        if (largest == i) {
            return;
        }
        int tmp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = tmp;
        maxHeapify(arr, largest, heapSize);
    }

    private static int[] buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
        return arr;
    }

    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        int heapSize = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            int max = arr[0];
            arr[0] = arr[i];
            arr[i] = max;
            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        buildMaxHeap(arr);
        Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
        System.out.println();
        heapSort(arr);
        Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
    }
}
