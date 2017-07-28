package com.hieblmi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

public class Compare {

    private static class Pair implements Comparable<Pair> {
        private int a;
        private int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair<T> o) {
            return  ? -1 : a > o.getA() ? 1 :
        }

        public String toString() {
            return a + "|" + b;
        }

        public T getA() {
            return a;
        }

        public T getB() {
            return b;
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
    }
}
