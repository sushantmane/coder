package edu.sjsu.cs.cs255.arrays;

public class StringBuilder {

    char[] buf;
    int capacity = 16; // default capacity
    int len = 0;

    public StringBuilder(String str) {
        this(str.length() + 16);
        for (int i = 0; i < str.length(); i++) {
            buf[i] = str.charAt(i);
            len++;
        }
    }

    public StringBuilder(int capacity) {
        this.buf = new char[capacity];
        this.capacity = capacity;
    }

    public StringBuilder() {
        buf = new char[capacity];
    }

    private void resize() {
        resize(capacity);
    }

    private void resize(int delta) {
        char[] tmp = new char[delta + capacity];
        copyTo(buf, tmp);
        buf = tmp;
        capacity += delta;
    }

    private void copyTo(char[] src, char[] dest) {
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    String string() {
        return String.copyValueOf(buf, 0, len);
    }

    public int capacity() {
        return capacity;
    }

    public int length() {
        return len;
    }

    public void append(String str) {
        while (str.length() > (capacity - len)) {
            resize();
        }
        for (int i = 0; i < str.length(); i++) {
            buf[len + i] = str.charAt(i);
        }
        len += str.length();
    }
}
