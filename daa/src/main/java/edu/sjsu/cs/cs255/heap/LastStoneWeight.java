package edu.sjsu.cs.cs255.heap;

import java.util.ArrayList;
import java.util.List;

public class LastStoneWeight {

    List<Integer> heap = new ArrayList<>();

    void add(int n) {
        heap.add(n);
        int i = heap.size() - 1;
        int p = (i - 1) / 2;
        while (p >= 0 && i >= 0 && heap.get(p) < heap.get(i)) {
            int old = heap.get(p);
            heap.set(p, heap.get(i));
            heap.set(i, old);
            int t = p;
            p = (p - 1) / 2;
            i = t;
        }
    }

    void heapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < heap.size() && heap.get(l) > heap.get(largest)) {
            largest = l;
        }
        if (r < heap.size() && heap.get(r) > heap.get(largest)) {
            largest = r;
        }
        if (largest == i) {
            return;
        }
        int t = heap.get(i);
        heap.set(i, heap.get(largest));
        heap.set(largest, t);
        heapify(largest);
    }

    boolean empty() {
        return heap.size() == 0;
    }

    int delete() {
        int first = heap.get(0);
        int last = heap.get(heap.size() - 1);
        heap.set(0, last);
        heap.remove(heap.size() - 1);
        heapify(0);
        return first;
    }


    public static void main(String[] args) {
        LastStoneWeight lsw = new LastStoneWeight();
        int[] arr = {3, 1, 4, 2, 5, 6, 7, 42, 10, 23, 13};

        for (int a : arr) {
            lsw.add(a);
        }

        lsw.delete();
        lsw.delete();
        System.out.println("heap: " + lsw.heap);
        lsw.add(42);
        lsw.add(23);
        System.out.println("heap: " + lsw.heap);
    }
}