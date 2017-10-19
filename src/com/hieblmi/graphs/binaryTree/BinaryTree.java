package com.hieblmi.graphs.binaryTree;

import java.util.LinkedList;
import java.util.List;

class BinaryTree<T extends Integer> {

    private Node<T> root;
    private int numberOfNodes;

    BinaryTree() {
    }

    BinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insert(Node<T> n) {
        numberOfNodes++;
        if (root == null) {
            root = n;
        } else {
            insertRec(n, root);
        }
    }

    private void insertRec(Node n, Node current) {
        if (n.getData().compareTo(current.getData()) < 0) {
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

    private int getMaximumHeight() {
        return (int) Math.ceil(Math.log(numberOfNodes) / Math.log(2));
    }

    public void print() {
        System.out.println("Number of nodes: " + numberOfNodes);
        System.out.println("Maximum height: " + getMaximumHeight());
        List<Integer> list = new LinkedList<>();
        printRec(root, list);

        for (int i = 0; i < getMaximumHeight(); i++) {
            for (int j = 0; j < (int) Math.pow(2, i); j++) {
                if (list.size() > 0) {
                    System.out.print(list.remove(0));
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }

    private void printRec(Node<T> n, List<Integer> list) {
        if (n.getLeft() != null) printRec(n.getLeft(), list);
        System.out.print(n.getData() + " ");
        if (n.getRight() != null) printRec(n.getRight(), list);
    }

    public boolean isBinaryTree() {
        return isBinaryTreeRec(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBinaryTreeRec(Node n, Integer max, Integer min) {

        if (n == null) return true;
        if (n.getData() < max && n.getData() > min) {
            return isBinaryTreeRec(n.getLeft(), n.getData(), min) && isBinaryTreeRec(n.getRight(), max, n.getData());
        } else {
            return false;
        }
    }

    // see http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
    public Node<T> lowestCommonAncestor(Node<T> n1, Node<T> n2, Node<T> current) {

        if(current == null) return root;

        int d1 = n1.getData();
        int d2 = n2.getData();
        int c = current.getData();

        if(d1 == c || d2 == c) return current;
        if(d1 < c && c < d2) return current;
        if(c < d1) return lowestCommonAncestor(n1, n2, current.getRight());
        return lowestCommonAncestor(n1, n2, current.getLeft());
    }

    public boolean isBalanced() {
        return true; //return isBalancedRec(root, 0);
    }



    private void rotateLeft() {

    }

    private void rotateRight() {

    }
}
