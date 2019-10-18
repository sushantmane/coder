package cpc.oj.projecteuler;

public class P2_EvenFibonacciNumbers {

    public static long solution(long n) {
        long f1 = 1;
        long f2 = 1;

        long next = 0;
        long sum = 0;
        while (true) {
            next = f1 + f2;
            if (next >= n) {
                break;
            }
            f1 = f2;
            f2 = next;
            if (next % 2 == 0) {
                sum += next;
            }
        }
        return sum;
    }

    public static long solution_UsingFormula(long n) {
        long f1 = 2;
        long f2 = 0;
        long f = 2;
        long sum = 0;
        while (f < n) {
            sum += f;
            f = f1 * 4 + f2;
            f2 = f1;
            f1 = f;
        }
        return sum;
    }

    public static long solution_UsingPropertyEveryThirdNumIsEven(long n) {
        long sum = 0;
        long a = 1;
        long b = 1;
        long c = a + b;
        while (c < n) {
            sum += c;
            a = b + c;
            b = c + a;
            c = a + b;
        }
        return sum;
    }
}
