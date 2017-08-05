package com.hieblmi.graphs.binaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(new Node<Integer>(5));
        bt.insert(new Node<Integer>(4));
        bt.insert(new Node<Integer>(3));
        bt.insert(new Node<Integer>(2));
        bt.insert(new Node<Integer>(7));
        bt.insert(new Node<Integer>(6));
        bt.print();
    }
}
