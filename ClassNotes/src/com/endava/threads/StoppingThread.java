package com.endava.threads;

public class StoppingThread {

    public void foo() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Hello!");
        });

        thread1.start();

        Thread.sleep(100L);

        thread1.interrupt();

        StoppingThread stoppingThread = new StoppingThread();

        Thread thread2 = new Thread(() -> {
            while (!Thread.currentThread().interrupted()) {
                stoppingThread.foo();
            }
        });

        thread2.start();

        Thread.sleep(100L);

        thread2.interrupt();

        Thread thread3 = new Thread(() -> {
            while (true) {
                System.out.println("Hello from Daemon");
            }
        });

        thread3.setDaemon(true);

        thread3.start();

        Thread.sleep(100L);
    }
}
