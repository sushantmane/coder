package edu.sjsu.cs.cs255.heap;

import java.util.Arrays;

public class MinHeap {

    private static void minHeapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < arr.length && arr[i] > arr[left]) {
            smallest = left;
        }
        if (right < arr.length && arr[smallest] > arr[right]) {
            smallest = right;
        }
        if (smallest == i) {
            return;
        }
        int min = arr[smallest];
        arr[smallest] = arr[i];
        arr[i] = min;
        minHeapify(arr, smallest);
    }

    public static int[] build(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            minHeapify(arr, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {16, 14, 9, 10, 7, 8, 3, 1, 4, 2};
        build(arr);
        Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
        System.out.println();
    }
}
