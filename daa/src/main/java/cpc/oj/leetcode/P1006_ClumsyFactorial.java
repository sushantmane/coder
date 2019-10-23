package cpc.oj.leetcode;

import java.util.Stack;

public class P1006_ClumsyFactorial {

    public static int clumsy(int N) {
        Stack<String> stack = new Stack<>();

        int j = 0;
        for (int i = N; i > 0; i--) {
            stack.push(i +"");
            if (i == 1) {
                break;
            }
            switch (j) {
                case 0:
                    stack.push("*");
                    break;
                case 1:
                    stack.push("/");
                    break;
                case 2:
                    stack.push("+");
                    break;
                case 3:
                    stack.push("-");
                    j = 0;
                    continue;
            }
            j++;
        }

        System.out.println(stack);
        return 0;
    }
}
