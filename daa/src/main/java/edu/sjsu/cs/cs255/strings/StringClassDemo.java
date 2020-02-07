package edu.sjsu.cs.cs255.strings;

import java.util.Arrays;

public class StringClassDemo {


    static void perm(String str) {
        perm(str, "");
    }

    static void perm(String str, String prefix) {
        System.out.println("str:" + str + " pf:" + prefix);
        if (str.length() == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            perm(rem, prefix + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        int[] lookupTable = new int[256];
        for (int i = 1; i < 256; i++) {
            lookupTable[i] = lookupTable[i >> 1] + (i & 1);
        }
        int n = 15;
        int ones = lookupTable[n & 0xFF]
                + lookupTable[n >> 8]
                + lookupTable[n >> 16]
                + lookupTable[n >> 24];
        System.out.println(ones);
    }
}
