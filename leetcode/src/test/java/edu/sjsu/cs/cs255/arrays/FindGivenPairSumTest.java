package edu.sjsu.cs.cs255.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FindGivenPairSumTest {

    @Test
    void solutionWithSort() {
        int[] arr = {20, 50, 40, 25, 30, 10, 10};
        int[] res = FindGivenPairSum.solutionWithSort(arr, 90);
        System.out.println();
        Arrays.stream(res).forEach(k -> System.out.print(k + " "));
        System.out.println();


        int[] arr1 = {90, 85, 75, 60, 120, 150, 125};
        int[] res1 = FindGivenPairSum.solutionWithSort(arr1, 250);
        System.out.println();
        Arrays.stream(res1).forEach(k -> System.out.print(k + " "));
        System.out.println();
    }

    @Test
    void solutionWithHT() {
        int[] arr = {20, 50, 40, 25, 30, 10, 10};
        int[] res = FindGivenPairSum.solutionWithHT(arr, 90);
        System.out.println();
        Arrays.stream(res).forEach(k -> System.out.print(k + " "));
        System.out.println();

        int[] arr1 = {20, 60, 40, 25, 30, 10};
        int[] res1 = FindGivenPairSum.solutionWithHT(arr1, 90);
        System.out.println();
        Arrays.stream(res1).forEach(k -> System.out.print(k + " "));
        System.out.println();

        int[] arr2 = {1, 10, 25, 35, 60};
        int[] res2 = FindGivenPairSum.solutionWithHT(arr2, 90);
        System.out.println();
        Arrays.stream(res2).forEach(k -> System.out.print(k + " "));
        System.out.println();


        int[] arr3 = {1, 10, 25, 35, 60};
        for (int i = 0, j = arr3.length - 1; i <= j; i++, j--) {
            int tmp = arr3[i];
            arr3[i] = arr3[j];
            arr3[j] = tmp;
        }
        Arrays.stream(arr3).forEach(k -> System.out.print(k + " "));
        int[] res3 = FindGivenPairSum.solutionWithHT(arr3, 90);
        System.out.println();
        Arrays.stream(res3).forEach(k -> System.out.print(k + " "));
        System.out.println();


        int[] arr4 = {20, 50, 40, 25, 30, 10};
        for (int i = 0, j = arr4.length - 1; i <= j; i++, j--) {
            int tmp = arr4[i];
            arr4[i] = arr4[j];
            arr4[j] = tmp;
        }
        Arrays.stream(arr4).forEach(k -> System.out.print(k + " "));
        int[] res4 = FindGivenPairSum.solutionWithHT(arr4, 90);
        System.out.println();
        Arrays.stream(res4).forEach(k -> System.out.print(k + " "));
        System.out.println();

    }
}