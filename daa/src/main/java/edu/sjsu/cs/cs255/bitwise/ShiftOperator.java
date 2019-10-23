package edu.sjsu.cs.cs255.bitwise;

public class ShiftOperator {

    static void get2sComplement(int num) {
        System.out.print("Bi: ");
        for (int i = 31; i > 0; i--) {
            int res = num & (1 << i);
            if (res == 0) {
                System.out.print("1 ");
                continue;
            }
            System.out.print("0 ");
        }
        System.out.println(num & 1);
    }

    static void printBits(int num) {
        for (int i = 31; i >= 0; i--) {
            int res = num & (1 << i);
            if (res == 0) {
                System.out.print("0 ");
                continue;
            }
            System.out.print("1 ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ShiftOperator.printBits(-12);
    }
}
