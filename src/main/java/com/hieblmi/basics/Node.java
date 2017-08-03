package com.hieblmi.basics;

public class Node<T> {

    private T data;
    private Node<T> next;

    Node(T d) {
        this.data = d;
    }

    public T getData() { return this.data; }
    public Node<T> getNext() { return this.next; }
    public void setNext(Node<T> n) { this.next = n; }
}
