package edu.sjsu.cs.cs255.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountingSort {

    public static void csortWithMap(int[] arr) {
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int a : arr) {
            freq.compute(a, (k, v) -> v == null ? 1 : v + 1);
        }
        int p = 0;
        for (int k : freq.keySet()) {
            int cnt = freq.get(k) + p;
            freq.put(k, cnt);
            p = cnt;
        }

        int[] res = new int[arr.length];
        for (int a : arr) {
            res[freq.get(a) - 1] = a;
            freq.computeIfPresent(a, (k, v) -> v - 1);
        }
        System.arraycopy(res, 0, arr, 0, arr.length);
        System.out.println(freq);
    };


    public static void csort(int[] arr) {
        // compute the max number
        int max = arr[2];
        for (int a : arr) {
            max = Math.max(max, a);
        }

        // create an array to hold frequency of each number
        int[] cArr = new int[max + 1];
        for (int a : arr) {
            cArr[a] += 1;
        }
        Arrays.stream(cArr).forEach(k -> System.out.print(k + " "));
        System.out.println();

        // calculate how many numbers are there before this number
        for (int i = 1; i < cArr.length; i++) {
            cArr[i] += cArr[i - 1];
        }
        Arrays.stream(cArr).forEach(k -> System.out.print(k + " "));

        // use positional indexes and original array to create sorted array
        int[] bArr = new int[arr.length];
        for (int a : arr) {
            bArr[cArr[a] - 1] = a;
            cArr[a] -= 1;
        }

        System.arraycopy(bArr, 0, arr, 0, arr.length);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        csort(arr);
        Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
        int[] arr2 = {2, 5, 3, 0, 2, 3, 0, 3};
        csortWithMap(arr2);
        Arrays.stream(arr2).forEach(k -> System.out.print(k + " "));
        System.out.println();
    }
}
