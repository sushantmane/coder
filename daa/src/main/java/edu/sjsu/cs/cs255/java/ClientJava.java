package edu.sjsu.cs.cs255.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;

public class ClientJava {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("10.32.41.1", 5144);
        System.out.println("connected...");
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int i = 1, sum = 0;
        int rt = 100;
        String res;
        long t1;
        long t2;
        long t3;
        long t4;
        socket.getOutputStream().write("\n".getBytes());
        res = br.readLine();
        double offSet = 0;
        while (i++ <= rt) {
            t1 = System.nanoTime();
            socket.getOutputStream().write("\n".getBytes());
            t2 = System.nanoTime();
            res = br.readLine();
            t4 = System.nanoTime();
            t3 = Long.parseLong(res);
            double offset = ((t3 - t2) + (t3 - t4)) / 2.0;
            offSet += offset;
            double delay = (t3 - t2) - (t3 - t4);
            //System.out.println("offset:" + offset + " delay:" + delay);
            System.out.printf("offset:%.0f delay:%.0f\n", offset, delay);
            Thread.sleep(5);
        }
        offSet = offSet / rt;
        i = 1;
        while (i++ <= rt) {
            socket.getOutputStream().write(("time:" + (System.nanoTime() + (long) Math.ceil(offSet)) + "\n").getBytes());
            Thread.sleep(5);
        }
    }
}
