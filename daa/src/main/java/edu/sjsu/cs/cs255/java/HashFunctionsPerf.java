package edu.sjsu.cs.cs255.java;

import com.google.common.io.BaseEncoding;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Set;

public class HashFunctionsPerf {

    public static void perfTest(String hashFunction) throws NoSuchAlgorithmException {
        MessageDigest di = MessageDigest.getInstance(hashFunction);
        String msg = "San Jose State University - Systems Research Group";
        di.update(msg.getBytes());
        long tn1 = System.nanoTime();
        long tm1 = System.currentTimeMillis();
        byte[] bytes = di.digest();
        long tm2 = System.currentTimeMillis();
        long tn2 = System.nanoTime();
        System.out.println(hashFunction + " nano: " + (tn2 - tn1) + " milli: " + (tm2 - tm1));
//        System.out.println(BaseEncoding.base16().lowerCase().encode(bytes));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Set<String> hashFunctions = Security.getAlgorithms("MessageDigest");
        for (String hashFunction : hashFunctions) {
            perfTest(hashFunction);
        }
    }
}


//
//nano: 8716855
//        milli: 9
