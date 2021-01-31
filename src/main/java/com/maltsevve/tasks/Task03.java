package main.java.com.maltsevve.tasks;

class Foo {
    int counter = 0;

    void first() {
        System.out.print("first");
        counter++;
    }

    void second() {
        while (counter != 1){
            Thread.yield();
        }
        System.out.print("second");
        counter++;
    }

    void third() {
        while (counter != 2){
            Thread.yield();
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
