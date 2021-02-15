package edu.sjsu.cs.cs255.revision;

public class SortAlgorithms {

    private static void selectionSort(int[] arr) {
        int smallIdx;
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            smallIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallIdx]) {
                    smallIdx = j;
                }
            }
            if (smallIdx != i) {
                tmp = arr[smallIdx];
                arr[smallIdx] = arr[i];
                arr[i] = tmp;
            }
        }

        System.out.println();
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && (arr[j] > arr[j + 1]); j--) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
    }


    private static void heapSort(int[] arr) {

    }

    public static void main(String[] args) {
        int[] arr = {11, 22, 10, 22, 44, 8, 5, 2, -1, 98, 0, 7, -3};
//        selectionSort(arr);
        insertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

//
//                0
//            1        2
//        3       4   5     6
//
//
//// 0 1 2 3 4 5 6
////
////c = 2 * p + 1
////(c - 1) / 2 = p
////(c - 2) / 2 = p
////