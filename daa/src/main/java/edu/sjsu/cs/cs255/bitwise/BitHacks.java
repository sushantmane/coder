package edu.sjsu.cs.cs255.bitwise;

public class BitHacks {

    // compute the sign of an integer
    public static void signOfInt(int num) {
        if (num >> 31 != 0) {
            System.out.println("Negative");
            return;
        }
        System.out.println("Positive");
    }

    // determining if an integer is a power of 2
    public static boolean isPowerOfTwo(int num) {
        if (num == 0) {
            return false;
        }
        if ((num & (num - 1)) == 0) {
            return true;
        }
        System.out.println((num & (num - 1)));
        return false;
    }

    // count number of set bits (1's in binary representation) in given integer
    // Counting bits set, Brian Kernighan's way
    public static int countSetBits(int n) {
        int c = 0;
        while (n > 0) {
            n = n & (n - 1);
            c++;
        }
        return c;
    }

    // count number of set bits (1's in binary representation) in given integer
    public static int countSetBitsUsingLookupTable(int n) {
        int[] lookupTable = new int[256];
        for (int i = 0; i < 256; i++) {
            lookupTable[i] = lookupTable[i >> 1] + (i & 1);
        }
        return lookupTable[n & 0xFF]
                + lookupTable[n >> 8 & 0xFF]
                + lookupTable[n >> 16 & 0xFF]
                + lookupTable[n >> 24 & 0xFF];
    }

    // Detect if two integers have opposite signs
    public static boolean hasOppositeSign(int x, int y) {
        return (x ^ y) < 0;
    }

    // Determining if an integer is a power of 2
    public static boolean isPowerOf2(int n) {
        if (n == 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int a = countSetBitsUsingLookupTable(i);
            int b = countSetBits(i);
            System.out.println(i + " a: " + a + " b: " + b);
            if (a != b) {
                break;
            }
        }
    }
}
