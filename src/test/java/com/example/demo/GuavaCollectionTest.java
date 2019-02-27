package com.example.demo;

import com.google.common.collect.*;

import java.util.Random;

public class GuavaCollectionTest {
    public static void main(String[] args) {
        Multiset<String> multiset = getMultiSet(100);
        System.out.println(multiset);
    }

    public static Multiset<String> getMultiSet(int count) {
        Multiset<String> multiset = HashMultiset.create();
        Random rm = new Random();
        for(int i = 0 ; i < count; i++) {
            multiset.add(String.valueOf(rm.nextInt(20)));
        }
        return multiset;
    }
}
