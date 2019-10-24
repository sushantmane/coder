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

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(19));
    }
}
