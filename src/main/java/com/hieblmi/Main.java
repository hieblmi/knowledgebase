package com.hieblmi;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        IterableLinkedList<Node<Integer>> list = new IterableLinkedList<>();

        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));

        printList(list);
        removeFromList(list, 1);
        printList(list);
        removeFromList(list, 5);
        printList(list);
        removeFromList(list, 3);
        printList(list);
        list.add(new Node(2));
        printList(list);
        removeFromList(list, 2);
        printList(list);
        removeFromList(list, 2);
        printList(list);
        removeFromList(list, 4);
        printList(list);

        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(4));
        list.add(new Node(5));
        printList(list);

        removeFromList(list, 1);
        printList(list);
        removeFromList(list, 5);
        printList(list);
        removeFromList(list, 3);
        printList(list);
        list.add(new Node(2));
        printList(list);
        removeFromList(list, 2);
        printList(list);
        removeFromList(list, 2);
        printList(list);
        removeFromList(list, 4);
        printList(list);
    }

    private static void printList(IterableLinkedList<Node<Integer>> list) {
        Iterator it = list.iterator();
        System.out.println("--------");
        while(it.hasNext()) {
            int data = ((Node<Integer>)it.next()).getData();
            System.out.println(data);
        }
    }

    private static void removeFromList(IterableLinkedList<Node<Integer>> list, int data) {
        Iterator it = list.iterator();
        while(it.hasNext()) {
            int currentData = ((Node<Integer>)it.next()).getData();
            if(currentData == data) {
                it.remove();
                break;
            }
        }
    }
}
