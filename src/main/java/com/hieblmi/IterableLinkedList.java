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
    public String toString() {
        String content = "";
        Iterator it = iterator();
        while(it.hasNext()) {
            content += ((Node<Integer>)it.next()).getData();
        }
        return content;
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
               } else {
                    prev = current;
                    current = current.getNext();
               }
               return current;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if(prev == null) {
                current = null;
                if(head == end) {
                    end = null;
                }
                head = head.getNext();
            } else {
                prev.setNext(current.getNext());
                current = prev;
                if(current.getNext() == null) {
                    end = current;
                }
            }
        }
    }

}
