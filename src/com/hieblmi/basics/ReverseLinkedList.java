package com.hieblmi.basics;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node<Integer> head = new Node(1).setNext(new Node(2).setNext(new Node(3).setNext(new Node(4).setNext(new Node(5)))));
        print(head);
        head = reverse(head);
        print(head);
    }

    private static Node reverse(Node head) {
        Node newNext = null;
        Node newPrev = head;
        while(newPrev != null) {
            Node tmp = newPrev.getNext();
            newPrev.setNext(newNext);
            newNext = newPrev;
            newPrev = tmp;
        }
        return newNext;
    }

    private static void print(Node head) {
        while(head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.println();
    }
}
