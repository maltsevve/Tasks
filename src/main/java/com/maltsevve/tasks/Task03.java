package main.java.com.maltsevve.tasks;

import java.util.concurrent.CountDownLatch;

class Foo {
    CountDownLatch cdl = new CountDownLatch(1);
    CountDownLatch cdl2 = new CountDownLatch(1);

    void first() {
        System.out.print("first");
        cdl.countDown();
    }

    void second() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("second");
        cdl2.countDown();
    }

    void third() {
        try {
            cdl2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("third");
    }
}

class Task03 {
    public static void main(String[] args) {
        Foo foo = new Foo();

        new Thread(foo::first, "A").start();
        new Thread(foo::second, "B").start();
        new Thread(foo::third, "C").start();
    }
}
