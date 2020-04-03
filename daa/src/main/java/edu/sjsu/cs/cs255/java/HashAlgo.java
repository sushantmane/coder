package edu.sjsu.cs.cs255.java;

import com.google.common.io.BaseEncoding;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.HashSet;
import java.util.Set;

public class HashAlgo {

//    static {
//        System.out.println("Hello");
//        Set<String> digestAlgos = Security.getAlgorithms("MessageDigest");
//        String msg = "San Jose State University!";
//        for (String algo : digestAlgos) {
//            MessageDigest di = null;
//            try {
//                di = MessageDigest.getInstance(algo);
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//            di.update(msg.getBytes());
//            byte[] bytes = di.digest();
//            System.out.println(algo + "(" + bytes.length + "):\t\t" + BaseEncoding.base16().lowerCase().encode(bytes)
//                    + " long: " + getLongVal(bytes, 0, 8));
//        }
//    }

    // todo: check if offset + length < digest size
    private static long getLongVal(byte[] digest, int offset, int length) {
        long val = 0;
        for (int i = offset; i < offset + length; i++) {
            val <<= 8;
            val ^=  digest[i] & 0xFF;
        }
        return val;
    }

    //             // l = ByteBuffer.wrap(md.digest()).getLong(0);


//    public static byte[] longToByteArray(long value) {
//        return new byte[] {
//                (byte) (value >> 56),
//                (byte) (value >> 48),
//                (byte) (value >> 40),
//                (byte) (value >> 32),
//                (byte) (value >> 24),
//                (byte) (value >> 16),
//                (byte) (value >> 8),
//                (byte) value
//        };
//    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("SHA-512");
//        md.update("San Jose State University!".getBytes());
//        byte[] b1 = "San ".getBytes();
//        byte[] b2 = "Jose ".getBytes();
//        byte[] b3 = "State ".getBytes();
//        byte[] b4 = "University!".getBytes();
//        byte[] bb = new byte[b1.length + b2.length + b3.length + b4.length];
//        ByteBuffer buf = ByteBuffer.wrap(bb);
//        buf.put(b1);
//        buf.put(b2);
//        buf.put(b3);
//        buf.put(b4);
//        buf.flip();
////        buf.get(bb);
////        buf.put("San Jose State University!".getBytes());
//        MessageDigest mdU = MessageDigest.getInstance("SHA-512");
//        mdU.update(bb);
//        System.out.println("ok: " + BaseEncoding.base16().lowerCase().encode(mdU.digest()));
//        byte[] digest = md.digest();
//        System.out.println("Guava: " + BaseEncoding.base16().lowerCase().encode(digest));
//        System.out.println("BigInt: " + new BigInteger(1, digest).toString(16));
//        ByteBuffer buffer = ByteBuffer.wrap(digest);
//        long sdl = buffer.getLong(0);
//        System.out.println("ShortVersion: " + sdl);
//        byte[] dig = ByteBuffer.allocate(Long.SIZE / Byte.SIZE).putLong(sdl).array();
//        System.out.println("Guava: " + BaseEncoding.base16().lowerCase().encode(dig));
//        System.out.println("BigInt: " + new BigInteger(1, dig).toString(16));
//        ByteBuffer bb1 = ByteBuffer.wrap(BaseEncoding.base16().lowerCase().decode("51f1893267ed022a"));
//        System.out.println("LongVal: " + bb1.getLong());
//        System.out.println("len: " + digest.length);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 8; i++) {
//            sb.append(Long.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
//        }
//        String signature = sb.toString();
//        System.out.println(signature);
//        System.out.println("Guava: " + BaseEncoding.base16().lowerCase().encode(longToByteArray(5904651436044386858L)));
//        long l = 0;
//        for(int i = 0; i < 8; i++) {
//            l <<= 8;
//            l |= digest[i] & 0xFF;
//        }
//        System.out.println(l);

        Set<String> digestAlgos = Security.getAlgorithms("MessageDigest");
        System.out.println(digestAlgos);
        String msg = "San Jose State University";
        digestAlgos = new HashSet<>();

        digestAlgos.add("SHA-1");
//        digestAlgos.add("SHA-");
        System.out.println(digestAlgos);
        for (String algo : digestAlgos) {
            MessageDigest di = MessageDigest.getInstance(algo);
            di.update(msg.getBytes());
            byte[] bytes = di.digest();
            System.out.println(algo + "(" + bytes.length + "):\t\t" + BaseEncoding.base16().lowerCase().encode(bytes));
        }
    }

}

