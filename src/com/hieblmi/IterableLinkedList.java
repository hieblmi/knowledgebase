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


        MyLinkedListIterator() {
            current = head;
            prev = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<T> next() {
            if(hasNext()) {
                if(current == head) {
                    current = head.getNext();
                    return head;
                } else {

                }
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if(head == null) {
                return;
            }

            if(current == head) {
                current = current.getNext();
                head = current;
                prev = current;
            } else {
                prev.setNext(current.getNext());
                current = prev.getNext();
            }
        }
    }

}
