package cpc.oj.leetcode;

import java.util.concurrent.CountDownLatch;

public class P1114_PrintInOrder {

    class Foo {

        CountDownLatch latch = new CountDownLatch(3);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            while (latch.getCount() != 3) ;
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            latch.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (latch.getCount() != 2) ;
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            latch.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (latch.getCount() != 1) ;
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            latch.countDown();
        }
    }
}