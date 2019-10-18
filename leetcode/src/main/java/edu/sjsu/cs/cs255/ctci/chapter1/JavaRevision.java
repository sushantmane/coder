package edu.sjsu.cs.cs255.ctci.chapter1;

import java.util.Arrays;

public class JavaRevision {


    static void computeRuler() {
        String ruler = "1";
        for (int i = 2; i <= 15; i++) {
            ruler = ruler + " " + i + " " + ruler;
        }
        System.out.println(ruler);
    }

    static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    static void demo2DArray() {
        int[][] twoD = new int[5][4];

    }

    public static void main(String[] args) {
        //JavaRevision.computeRuler();
        int[] arr = {11, 22, 33, 44, 55, 66};
        JavaRevision.reverseArray(arr);
        Arrays.stream(arr).forEach(k -> System.out.print(k + " "));
    }
}
