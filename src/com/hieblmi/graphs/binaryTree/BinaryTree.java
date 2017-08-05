package com.hieblmi.graphs.binaryTree;

class BinaryTree<T extends Comparable> {

    private Node<T> root;

    public void insert(Node<T> n) {
        insertRec(n, root);
    }

    private void insertRec(Node n, Node current) {
        if (root == null) {
            root = n;
            return;
        } else if (n.getData().compareTo(current.getData()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(n);
            } else {
                insertRec(n, current.getLeft());
            }
        } else if (n.getData().compareTo(current.getData()) > 0) {
            if (current.getRight() == null) {
                current.setRight(n);
            } else {
                insertRec(n, current.getRight());
            }
        }
    }

    public void print() {
        printRec(root);
    }

    private void printRec(Node<T> n) {
        if (n.getLeft() != null) printRec(n.getLeft());
        System.out.println(n.getData());
        if (n.getRight() != null) printRec(n.getRight());
    }

    private boolean isBinaryTree(Node n) {

        return true;
    }

    private Node<T> lowestCommonAncestor(Node<T> n1, Node<T> n2) {

        return null;
    }

    private void rotateLeft() {

    }

    private void rotateRight() {

    }
}
