package edu.sjsu.cs.cs255.java;

public class RollingString {

    public static String roll(String str, String[] ops) {
        int ord = 'a' - 97;
//        ord = (('z' - 97) + 1) % 26;
        ord = (('b' - 97) - 1 + 26) % 26;
        System.out.println("ord:" + ord);
        char c = (char) (ord + 97);
        System.out.println("o: " + c + " ");
        return null;
    }

    public static String solution(String str, String[] ops) {
        char[] chars = str.toCharArray();
        int start;
        int end;
        String move;
        int ord;
        char c;
        String[] arr;
        for (String op : ops) {
            arr = op.split(" ");
            start = Integer.parseInt(arr[0]);
            end = Integer.parseInt(arr[1]);
            move = arr[2];
            System.out.println("move:" + move);
            for (int i = start; i <= end; i++) {
                c = chars[i];
                if ("L".equals(move)) {
                    ord = (((c - 97) - 1 + 26) % 26) + 97;
                } else {
                    ord = (((c - 97) + 1) % 26) + 97;
                }
                c = (char) ord;
                System.out.print(c);
                chars[i] = c;
            }
            System.out.println();
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String str = "abc";
        String[] ops = {"0 0 L", "2 2 L", "0 2 R"};
        System.out.println(solution(str, ops));
    }
}
