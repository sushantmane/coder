package edu.sjsu.cs.cs255.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrisionBreak {

    public static int area(int n, int m, int[] h, int[] v) {
        List<Integer> hb = new ArrayList<>();
        List<Integer> vb = new ArrayList<>();
        for (int i = 0; i <= (n + 1); i++) {
            hb.add(i);
        }
        for (int i = 0; i <= (m + 1); i++) {
            vb.add(i);
        }
        for (int i : h) {
            hb.remove(hb.indexOf(i));
        }
        for (int i : v) {
            vb.remove(vb.indexOf(i));
        }
        int len = 0;
        int wid = 0;
        for (int i = 1; i < vb.size(); i++) {
            int d = vb.get(i) - vb.get(i - 1);
            if (d > len) {
                len = d;
            }
        }
        for (int i = 1; i < hb.size(); i++) {
            int d = hb.get(i) - hb.get(i - 1);
            if (d > wid) {
                wid = d;
            }
        }
        return len * wid;
    }

    public static void main(String[] args) {
        int[] h = {1, 2, 3};
        int[] v = {1, 2};
        area(3, 2, h, v);
    }
}
