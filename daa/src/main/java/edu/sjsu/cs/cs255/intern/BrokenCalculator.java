package edu.sjsu.cs.cs255.intern;

public class BrokenCalculator {

    public static int solution(int X, int Y) {
        if (X >= Y) {
            return X - Y;
        }
        int clicks = 0;
        while (X < Y) {
            if (Y % 2 == 0) {
                Y = Y / 2;
            } else {
                Y++;
            }
            clicks++;
        }
        return clicks + X - Y;
    }
}
