package com.hieblmi.graphs.djikstra;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
    private int id;
    private boolean visited;
    private int dist;
    private Node prev;
    private List<Node> neighbors;

    Node(int id) {
        this.id = id;
        neighbors = new ArrayList<>();
        dist = Integer.MAX_VALUE;
        visited = false;
    }

    public void addNeighbor(Node n) {
        if(n != null) {
           neighbors.add(n);
        }
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    @Override
    public int compareTo(Node n) {
        return this.dist < n.getDist() ? 1 : this.dist == n.getDist() ? 0 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (visited != node.visited) return false;
        if (dist != node.dist) return false;
        if (!prev.equals(node.prev)) return false;
        return neighbors.equals(node.neighbors);
    }

    @Override
    public int hashCode() {
        int result = (visited ? 1 : 0);
        result = 31 * result + dist;
        result = 31 * result + prev.hashCode();
        result = 31 * result + neighbors.hashCode();
        return result;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getId() {
        return this.id;
    }
}
