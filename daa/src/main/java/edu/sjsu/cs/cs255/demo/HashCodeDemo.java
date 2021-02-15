package edu.sjsu.cs.cs255.demo;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

public class HashCodeDemo {

    static int hashC(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) * Math.pow(31, str.length() - 1 - i);
        }

        return sum;
    }

    public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        CRC32 crc321 = new CRC32();

        String[] strs = {"San", "Jose", "State", "University"};
        String[] strsU = {"San", "Hose", "State", "University"};
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < strs.length; i++) {
            crc32.reset();
            crc321.reset();
            crc32.update(strs[i].getBytes(StandardCharsets.UTF_8));
            crc321.update(strsU[i].getBytes(StandardCharsets.UTF_8));
            long v1 = crc32.getValue();
            long v2 = crc321.getValue();
//            System.out.println(strs[i].hashCode() + "  " + strsU[i].hashCode() + " crc: " + crc32.getValue());
            System.out.println(v1 + " " + v2);
            crc32.reset();
            crc321.reset();
            sum1 += v1;
            sum2 += v2;
        }
        crc32.reset();
        crc321.reset();
        crc32.reset();
        crc321.reset();
        crc32.update("Jose".getBytes(StandardCharsets.UTF_8));
        crc321.update("Hose".getBytes(StandardCharsets.UTF_8));
        long v1 = crc32.getValue();
        long v2 = crc321.getValue();

        long sub = sum2 + v1 - v2;
        System.out.println(sum1 + " " + sum2 + " : " + sub);
    }
}
