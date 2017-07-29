package com.hieblmi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class Compare {

    private static class Pair<T extends Comparable> implements Comparable<Pair<T>> {
        private T a;
        private T b;

        Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair<T> o) {
            if(a.compareTo(o.getA()) == 0) {
                return b.compareTo(o.getB());
            } else {
                return a.compareTo(o.getA());
            }
        }

        public T getA() {
            return a;
        }

        public T getB() {
            return b;
        }

        public String toString() {
            return a + "|" + b;
        }
    }

    public static void main(String[] args) {
        List<Pair<Integer>> list = new ArrayList<>();
        list.add(new Pair<Integer>(1,3));
        list.add(new Pair<Integer>(4,8));
        list.add(new Pair<Integer>(1,1));
        list.add(new Pair<Integer>(1,2));
        list.add(new Pair<Integer>(2,4));
        list.add(new Pair<Integer>(2,5));
        list.add(new Pair<Integer>(3,1));

        Collections.sort(list);
        System.out.println(list.toString());
        Collections.sort(list, new Comparator<Pair<Integer>>() {
            @Override
            public int compare(Pair<Integer> o1, Pair<Integer> o2) {
                if(o1.getA() == o2.getA()) {
                    return o1.getB().compareTo(o2.getB());
                } else {
                    return o1.getA().compareTo(o2.getA());
                }
            }
        });

        System.out.println(list.toString());
    }
}
