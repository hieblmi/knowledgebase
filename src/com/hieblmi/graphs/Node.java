package com.hieblmi.graphs;

import java.util.List;
import java.util.ArrayList;

class Node<T> {
    private List<Node<T>> neighbors;
    private T data;
    private Node<T> prev;

    Node(T data) {
        this.data = data;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node<T> n) {
        neighbors.add(n);
    }

    public List<Node<T>> neighbors() {
        return neighbors;
    }

    public T getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Node) {
            return data == ((Node)o).data;
        }

        return false;
    }

    //@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + ((data == null) ? 0 : data.hashCode());
    }
}
