package com.hieblmi.graphs.djikstra;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static int graph1[][] = new int[][]{
            {0, 7, 9, 0, 0, 14},
            {7, 0, 10, 15, 0, 0},
            {9, 10, 0, 11, 0, 2},
            {0, 15, 11, 6, 0, 0},
            {0, 0, 0, 6, 0, 9},
            {14, 0, 2, 0, 9, 0},
    };

    public static int[][] graph2 = new int[][]{
        {0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}
    };

    public static void main(String[] args) {
        Djikstra djikstra = new Djikstra(graph1);
        djikstra.findShortestPathFromSource(0);

        DjikstraWithPriorityQueue djikstraPrio = new DjikstraWithPriorityQueue();
        djikstraPrio.readGraphFromArray(graph1);
        djikstraPrio.findShortesPath(0);


        try {
            final Scanner in = new Scanner(Paths.get("src/hackerrankDjikstra"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
