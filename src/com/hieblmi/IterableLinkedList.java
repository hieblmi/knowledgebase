package com.hieblmi;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableLinkedList<T> implements Iterable<Node<T>> {

    private Node<T> head;
    private Node<T> end;

    public Node<T> getHead() {
        return head;
    }

    public void add(Node<T> n) {
        if(head == null) {
            head = n;
            end = head;
        } else {
            end.setNext(n);
            n.setNext(null);
            end = n;
        }
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<Node<T>> {

        private Node<T> current;
        private Node<T> prev;


        MyLinkedListIterator() {}

        @Override
        public boolean hasNext() {
            if(current == null) {
                return head != null;
            } else {
                return current.getNext() != null;
            }
        }

        @Override
        public Node<T> next() {
            if(hasNext()) {
               if(current == null) {
                   current = head;
                   return current;
               } else {
                    prev = current;
                    current = current.getNext();
               }
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if(prev == null) {
                current = null;
                head = head.getNext();
            } else {
                prev.setNext(current.getNext());
                current = prev;
            }
        }
    }

}
