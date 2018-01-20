package edu.princeton.cs.algs4.clients;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.BreadthFirstSearch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * Client for the BreadthFirstSearch class, which performs a BFS for identifying
 * all the vertices which are connected to a specific source vertex.
 *
 * Usage example:
 *   java BreadthFirstSearchClient graph.txt 4
 */
public class BreadthFirstSearchClient {
    public static void main(String[] args) {
        String filename = args[0];
        int source = Integer.parseInt(args[1]);
        Graph graph = new Graph(new In(filename));

        // Perform graph search
        BreadthFirstSearch search = new BreadthFirstSearch(graph, source);

        // Print connected vertices
        StdOut.println("Vertices connected to vertex " + source + ":");
        for (int i = 0; i < graph.getV(); i++)
            if (search.marked(i)) StdOut.print(i + " ");
        StdOut.println();

        // Print disconnected vertices
        StdOut.println("Vertices NOT connected to vertex " + source + ":");
        if (search.count() == graph.getV())
            StdOut.print("none");
        else
            for (int i = 0; i < graph.getV(); i++)
                if (!search.marked(i)) StdOut.print(i + " ");
        StdOut.println();
    }
}
