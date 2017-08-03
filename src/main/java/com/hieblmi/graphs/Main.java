package com.hieblmi.graphs;

import com.hieblmi.graphs.Node;

import java.util.HashMap;
import java.util.Map;

public class BFSMain {

    public static void main(String[] args) {
        Node<Integer> start = new Node<>(1);
        start.addNeighbor(new Node<>(2));
        start.addNeighbor(new Node<>(3));
        start.addNeighbor(new Node<>(4));
        Node<Integer> n = new Node<>(5);
        start.addNeighbor(n);
        n.addNeighbor(new Node<>(6));
        BFS<Integer> graph = new BFS<>(start);

        System.out.println(graph.find(new Node<Integer>((5))));

        Map<Node<Integer>, Integer> map = new HashMap<>();

        map.put(new Node(1), 3);

        System.out.println(map.get(new Node(1)));

        DFS<Integer> dfsGraph = new DFS<>(start);
        System.out.println(graph.find(new Node<Integer>((9))));
    }
}
