package edu.sjsu.cs.cs255.arrays;

import org.junit.jupiter.api.Test;


class StringBuilderTest {

    @Test
    public void testSb() {
        char[] in = {'s', 'a', 'n', ' ', 'j', 'o', 's', 'e', ' ', 's', 't', 'a', 't',
                'e', ' ', 'u', 'n', 'i', 'v', 'e', 'r', 's', 'i', 't', 'y'};
        StringBuilder sb = new StringBuilder(String.copyValueOf(in));
        System.out.println(sb.string());
        System.out.println("cap: " + sb.capacity() + " " + sb.length());
        sb.append("SAN JOSE STATE UNIVERSITY");
        System.out.println(sb.string());
        System.out.println("cap: " + sb.capacity() + " " + sb.length());
        sb.append("university");

        System.out.println(sb.string());
        System.out.println("cap: " + sb.capacity() + " " + sb.length());
        sb.append("university");

        System.out.println(sb.string());
        System.out.println("cap: " + sb.capacity() + " " + sb.length());

        sb.append("universityuniversityuniversityuniversityuniversity1234");
        System.out.println(sb.string());
        System.out.println("cap: " + sb.capacity() + " " + sb.length());
    }
}