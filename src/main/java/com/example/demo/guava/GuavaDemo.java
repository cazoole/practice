package com.example.demo.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.google.common.collect.Maps.newHashMap;

public class GuavaDemo {

    public static void main(String[] args) {
        Map<String, String> map = newHashMap();
        CharMatcher.any();


        List<String> names = Lists.newArrayList("Aleksander", "Jaran", "Integrasco", "Guava", "Java");

        System.out.println(names);
        Iterable<String> iterable = Iterables.filter(names, lengthLessThan(7));

        names.forEach(s -> System.out.println(s));
        iterable.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    private static class LengthLessThanPredicate implements Predicate<String> {

        private final int length;

        public LengthLessThanPredicate(final int length) {
            this.length = length;
        }

        @Override
        public boolean apply(String input) {
            return input.length() < 5;
        }
    }

    public static Predicate<String> lengthLessThan(final int length) {
        return new LengthLessThanPredicate(length);
    }
}
