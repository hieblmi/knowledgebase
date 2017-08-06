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
        bt.insert(new Node<Integer>(10));
        bt.insert(new Node<Integer>(11));
        bt.insert(new Node<Integer>(12));
        System.out.println(bt.isBinaryTree());

        BinaryTree<Integer> nonBt = new BinaryTree<>(new Node<Integer>(10));
        Node<Integer> root = nonBt.getRoot();

        root.setLeft(new Node<Integer>(7));
        root.getLeft().setLeft(new Node<Integer>(6));
        root.getLeft().setRight(new Node<Integer>(9));
        System.out.println(nonBt.isBinaryTree());
    }
}
