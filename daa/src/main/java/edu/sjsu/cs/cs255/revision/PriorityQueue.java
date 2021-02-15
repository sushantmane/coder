package edu.sjsu.cs.cs255.revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PriorityQueue {

    List<Integer> list;
    Map<Integer, Set<Integer>> index = new HashMap<>();
    int capacity;
    int size;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(this.capacity);
    }

    public PriorityQueue() {
        this(32);
    }

    private void bubbleUp(int idx) {
        int parent = (idx - 1) / 2;
        while (idx > 0 && list.get(parent) > list.get(idx)) {
//            Set<Integer> iMapP = index.get(list.get(parent));
//            Set<Integer> iMap = index.get(list.get(idx));
//            iMapP.remove(parent);
//            iMapP.add(idx);
//            iMap.remove(idx);
//            iMap.add(parent);
            int t = list.get(parent);
            list.set(parent, list.get(idx));
            list.set(idx, t);
            idx = parent;
            parent = (idx - 1) / 2;
        }
    }

    public boolean add(int ele) throws InterruptedException {
        if (size == capacity) {
            return false;
        }

        list.add(ele);
//        Set<Integer> iMap = index.get(ele);
//        if (iMap == null) {
//            iMap = new TreeSet<>();
//            index.put(ele, iMap);
//        }
//        iMap.add(size);
        size++;
        bubbleUp(size - 1);
        return true;
    }

    private void pushDown(int idx) {
        if (idx >= size) {
            return;
        }

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        int smaller = idx;

        if (left < list.size() && list.get(left) < list.get(smaller)) {
            smaller = left;
        }

        if (right < list.size() && list.get(right) < list.get(smaller)) {
            smaller = right;
        }

        if (smaller != idx) {
            int tmp = list.get(idx);
            list.set(idx, list.get(smaller));
            list.set(smaller, tmp);
            pushDown(smaller);
        }
    }

    public int poll() throws IllegalAccessException {
        if (size == 0) {
            throw new IllegalAccessException();
        }

        int res = list.get(0);
        size--;
        list.set(0, list.get(size));
        pushDown(0);
        return res;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + " " + index.get((list.get(i))));
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    static java.util.PriorityQueue<Integer> testPq(int[] arr) {
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }

        System.out.println(pq);
        return pq;
    }

    public static void merge(int[] arr, int l, int m, int u) {
        int len = u - l + 1;
        int[] res = new int[len];
        int i = 0;
        int lI = l;
        int uI = m + 1;

        while (i < len) {
            if (lI > m) {
                res[i] = arr[uI];
                uI++;
                i++;
                continue;
            }
            if (uI > u) {
                res[i] = arr[lI];
                lI++;
                i++;
                continue;
            }
            if (arr[lI] < arr[uI]) {
                res[i] = arr[lI];
                lI++;
            } else {
                res[i] = arr[uI];
                uI++;
            }
            i++;
        }
        int k = 0;
        for (i = l; i <= u; i++, k++) {
            arr[i] = res[k];
        }
    }

    public static void mergeSort(int[] arr, int l, int u) {
        if (l == u) {
            return;
        }
        int mid = (l + u) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, u);
        merge(arr, l, mid, u);
        System.out.print("\n" + l + " " + u + " : ");
        for (int i = l; i <= u; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int getPartition(int[] arr, int l, int h) {
        int partIdx = h;
        int firstLargest = l;
        for (int i = l; i < h; i++) {
//            System.out.println(l + " " + h + " i: " + i);
            if (arr[i] < arr[partIdx]) {
                int tmp = arr[firstLargest];
                arr[firstLargest] = arr[i];
                arr[i] = tmp;
                firstLargest++;
            }
        }
        int tmp = arr[partIdx];
        arr[partIdx] = arr[firstLargest];
        arr[firstLargest] = tmp;

        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("-- l:" +  l + " h:" + h + " p: " + firstLargest);
        return firstLargest;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (h <= l) {
            return;
        }

        int p = getPartition(arr, l, h);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, h);
    }


    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        PriorityQueue pq = new PriorityQueue();
        int[] arr = {11, 22, 10, 22, 44, 8, 5, 2, -1, 98, 0, 7, -3};

        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();

//        mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);

//        for (int i = 0; i < arr.length; i++) {
//            pq.add(arr[i]);
//        }
//        pq.print();
//        System.out.println(pq.poll());
//        pq.print();
//        java.util.PriorityQueue<Integer> tpq =  testPq(arr);
//        System.out.println(tpq.poll());
//        System.out.println(tpq);
    }

}
