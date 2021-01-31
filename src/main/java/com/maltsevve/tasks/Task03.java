package main.java.com.maltsevve.tasks;

class Foo {
    void first() {
        System.out.print("first");
    }

    void second() {
        System.out.print("second");
    }

    void third() {
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

        MyThread A = new MyThread(foo, 1);
        try {
            A.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MyThread B = new MyThread(foo, 2);
        try {
            B.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new MyThread(foo, 3); // поток С
    }
}
