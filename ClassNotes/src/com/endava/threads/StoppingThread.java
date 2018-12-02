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
//        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(100L);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            System.out.println("Hello!");
//        });
//
//        thread.start();
//
//        Thread.sleep(100L);
//
//        thread.interrupt();

//        StoppingThread stoppingThread = new StoppingThread();
//
//        Thread thread = new Thread(() -> {
//            while (!Thread.currentThread().interrupted()) {
//                stoppingThread.foo();
//            }
//        });
//
//        thread.start();
//
//        Thread.sleep(100L);
//
//        thread.interrupt();

        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("Hello from Daemon");
            }
        });

        thread.setDaemon(true);

        thread.start();

        Thread.sleep(100L);
    }
}
