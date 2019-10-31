package edu.sjsu.cs.cs255.starpatterns;

public class StarPatterns {
    /*------------------
     *
     **
     ***
     ****
     *****
     ------------------*/
    static void patternA (int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    /*------------------
         *
        **
       ***
      ****
     *****
     ------------------*/
    static void patternB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    /*------------------
     *****
     ****
     ***
     **
     *
     ------------------*/
    static void patternC(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    /*------------------
     *****
      ****
       ***
        **
         *
     ------------------*/
    static void patternD(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        patternD(12);
    }
}
