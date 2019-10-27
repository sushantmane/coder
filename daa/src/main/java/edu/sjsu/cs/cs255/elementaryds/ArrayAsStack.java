package edu.sjsu.cs.cs255.elementaryds;

public class ArrayAsStack {

    private int[] arr;
    private int top = -1;

    public ArrayAsStack(int size) {
        arr = new int[size];
    }

    public void push(int ele) {
        if (top < arr.length - 1) {
            arr[top + 1] = ele;
            top = top + 1;
        }
    }

    public int pop() {
        int res = 0;
        if (top >= 0) {
            arr[top] = 0;
            top--;
            res = arr[top];
        }
        return res;
    }

    public int top() {
        if (top < 0) {
            return 0;
        }
        return arr[top];
    }

    public String toString() {
        String out = "";
        for (int i = 0; i <= top; i++) {
            out += arr[i] + " ";
        }
        return out;
    }

    public boolean isEmpty() {
        if (top < 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayAsStack stack = new ArrayAsStack(5);
        for (int i = 0; i < 5; i++) {
            stack.push(10 + i);
        }
        System.out.println(stack);
        for (int i = 0; i < 5 ; i++) {
            System.out.println("POP: " + stack.pop());
            System.out.println("TOP: " + stack.top());
            System.out.println("isEmpty: " + stack.isEmpty());
        }
    }
}
