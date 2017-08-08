package com.hieblmi.graphs.djikstra;

public class Djikstra {

    private final int[][] graph;
    int dist[];
    boolean visited[];

    Djikstra(int[][] graph) {
        this.graph = graph;
        this.dist = new int[graph.length];
        this.visited = new boolean[graph.length];
    }

    public void findShortestPathFromSource(int source) {

        for(int i=0; i<graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[source] = 0;

        for(int i=0; i<graph.length-1; i++) {

            int current = minDistance(dist, visited);
            visited[current] = true;

            for(int j=0; j<graph.length; j++) {
                if(!visited[j] && graph[current][j] != 0 && dist[current] + graph[current][j] < dist[j]) {
                    dist[j] = dist[current] + graph[current][j];
                }
            }
        }
        print();
    }

    private int minDistance(int[] dist, boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0; i<dist.length; i++) {
            if(visited[i] == false && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void print() {
        for(int i=0; i<dist.length; i++) {
            System.out.println("Node " + (int)(i+1) + " dist: " + dist[i]);
        }
    }
}
