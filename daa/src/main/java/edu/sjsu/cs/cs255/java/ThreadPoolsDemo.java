package edu.sjsu.cs.cs255.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolsDemo {

    int i = 0;

    public void increment() {
        synchronized (this) {
            i++;
        }
    }

    public void incrementNS() {
        synchronized (this) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ThreadPoolsDemo demo = new ThreadPoolsDemo();

        IntStream.range(0, 1000).forEach(c -> {
            if (c % 2 == 0) {
                executorService.submit(demo::increment);
            } else {
                executorService.submit(demo::incrementNS);
            }
        });
        executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        System.out.println(demo.i);
    }
}
