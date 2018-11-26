package com.endava.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

//        while (true) {
//            executorService.submit(() -> {
//                System.out.println("Hello + " + Thread.currentThread().getName());
//            });
//            try {
//                Thread.sleep(100L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        while (true) {
//            executorService.submit(() -> {
//                System.out.println("Hello + " + Thread.currentThread().getName());
//            });
//            try {
//                Thread.sleep(100L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
