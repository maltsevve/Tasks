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
        System.out.print("third");
    }
}

class MyThread implements Runnable {
    Foo foo;
    Integer num;
    Thread thread;

    MyThread(Foo foo, Integer num) {
        this.foo = foo;
        this.num = num;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        switch (num) {
            case 1 -> foo.first();
            case 2 -> foo.second();
            case 3 -> foo.third();
        }
    }
}

class Task03 {
    public static void main(String[] args) {
        Foo foo = new Foo();

        new MyThread(foo, 3);
        new MyThread(foo, 1);
        new MyThread(foo, 2);

    }
}
