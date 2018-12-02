package com.endava.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        Future<Double> future = Executors.newSingleThreadExecutor().submit(Math::random);

        Map<Integer, Character> chm = new ConcurrentHashMap<>();
        Map<Integer, Character> hm = new HashMap<>();

        chm.putIfAbsent(1 , 'c');
        chm.putIfAbsent(2 , 'd');
    }


}
