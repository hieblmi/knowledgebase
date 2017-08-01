package com.hieblmi;

import java.util.Iterator;
public class Main {

    public static void main(String[] args) {
        IterableLinkedList<Node<Integer>> list = new IterableLinkedList<>();

        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));

        Iterator<Node<Integer>> it = (Iterator<Node<Integer>>)list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getData());
        }
    }
}
