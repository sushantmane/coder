package edu.sjsu.cs.cs255.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5144);
        System.out.println("waiting for connection...");
        Socket socket = ss.accept();
        System.out.println("connected...");
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        OutputStream os = socket.getOutputStream();
        String line = br.readLine();
        while (line != null) {
            if (line.length() > 3) {
                long t2 = System.nanoTime();
                long t1 = Long.parseLong(line.trim().split(":")[1]);
                System.out.println(line + " diff:" + (t2 - t1));
            }
            os.write((System.nanoTime() + "\n").getBytes());
            line = br.readLine();
        }
        br.close();
        socket.close();
        ss.close();
    }
}
