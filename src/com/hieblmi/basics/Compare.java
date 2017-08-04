package com.hieblmi.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    private static class AscPairCmp<T extends Comparable> implements Comparator<Pair<T>> {
        @Override
        public int compare(Pair<T> p1, Pair<T> p2) {
            if(p1.getA() == p2.getA()) {
                return p1.getB().compareTo(p2.getB());
            } else {
                return p1.getA().compareTo(p2.getA());
            }
        }
    };
    public static AscPairCmp PAIR_COMPARATOR_ASCENDING = new AscPairCmp();

    private static class DescPairCmp<T extends Comparable> implements Comparator<Pair<T>> {
        @Override
        public int compare(Pair<T> p1, Pair<T> p2) {
            if(p1.getA() == p2.getA()) {
                return -p1.getB().compareTo(p2.getB());
            } else {
                return -p1.getA().compareTo(p2.getA());
            }
        }
    };
    public static DescPairCmp PAIR_COMPARATOR_DESCENDING = new DescPairCmp();

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

        Collections.shuffle(list);

        Collections.sort(list, PAIR_COMPARATOR_ASCENDING);

        System.out.println(list.toString());

        Collections.shuffle(list);

        Collections.sort(list, PAIR_COMPARATOR_DESCENDING);

        System.out.println(list.toString());
    }
}
