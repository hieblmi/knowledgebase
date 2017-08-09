package com.hieblmi.graphs.djikstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DjikstraWithPriorityQueue {

    private List<Node> nodes = new ArrayList<>();
    private Queue<Node> minQueue = new PriorityQueue<>();
    private int[][] graph;

    public void readGraphFromArray(int[][] graph) {

        this.graph = graph;

        for (int i = 0; i < graph.length; i++) { // the indices are the node's id
            Node n = new Node(i);
            nodes.add(n);
            minQueue.add(n);
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == j) {
                    continue;
                }
                if (graph[i][j] != 0) {
                    nodes.get(i).addNeighbor(nodes.get(j));
                }
            }
        }
    }

    public void findShortesPath(int source) throws IndexOutOfBoundsException {
        if (source < 0 || source >= nodes.size()) {
            throw new IndexOutOfBoundsException("Invalid Source");
        }

        nodes.get(source).setDist(0);

        Node current;
        while (!minQueue.isEmpty()) {
            current = minQueue.poll();

            for (Node n :
                    current.getNeighbors()) {
                if (!n.isVisited() && current.getDist() + graph[current.getId()][n.getId()] < n.getDist()) {
                    n.setDist(current.getDist() + graph[current.getId()][n.getId()]);
                    n.setPrev(current);
                }
            }
        }
        print();
    }

    private void print() {
        for (Node n:
             nodes) {
            System.out.println(n.getDist());
        }
    }

}
