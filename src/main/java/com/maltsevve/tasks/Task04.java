package main.java.com.maltsevve.tasks;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    int n;

    Semaphore semaphore = new Semaphore(1);
    Semaphore semaphore1 = new Semaphore(0);
    Semaphore semaphore2 = new Semaphore(0);
    Semaphore semaphore3 = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if ((i + 3) % 5 == 0) {
                i += 3;
            }
            semaphore1.acquire();
            printFizz.run();
            semaphore.release();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if ((i + 5) % 3 == 0) {
                i += 5;
            }
            semaphore2.acquire();
            printBuzz.run();
            semaphore.release();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        // 15 наименьшее число делящееся без остатка и на 3 и на 5
        for (int i = 15; i <= n; i += 15) {
            semaphore3.acquire();
            printFizzBuzz.run();
            semaphore.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphore.acquire();
            if (i % 3 != 0 & i % 5 != 0) {
                printNumber.accept(i);
                semaphore.release();
            } else if (i % 15 == 0) {
                semaphore3.release();
                if (i == n) {
                    semaphore.release();
                    semaphore1.release();
                    semaphore2.release();
                    semaphore3.release();
                }
            } else if (i % 5 == 0) {
                semaphore2.release();
            } else {
                semaphore1.release();
            }
        }
    }
}

class Task04 {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(35);

        Runnable printFizz = () -> System.out.println("fizz");
        Runnable printBuzz = () -> System.out.println("buzz");
        Runnable printFizzBuzz = () -> System.out.println("fizzbuzz");
        IntConsumer printNumber = number -> System.out.println(number);


        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
