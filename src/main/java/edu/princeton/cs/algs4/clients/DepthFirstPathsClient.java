package edu.princeton.cs.algs4.clients;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

/**
 * Client for the DepthFirstPaths class
 *
 * Usage example:
 *   java DepthFirstPathsClient graph.txt 4
 */
public class DepthFirstPathsClient {
    public static void main(String[] args) {
        String filename = args[0];
        int source = Integer.parseInt(args[1]);
        Graph graph = new Graph(new In(filename));
       
        // Find paths 
        DepthFirstPaths paths = new DepthFirstPaths(graph, source);

        // Print paths from source to any other vertex
        for (int i = 0; i < graph.getV(); i++) {
            StdOut.print("Path from " + source + " to " + i + ": ");
            if (paths.hasPathTo(i)) {
                for (int n : paths.getPathTo(i))
                    StdOut.print(n + " ");
                StdOut.println();
            }
            else
                StdOut.println("none");
        }
    }
}
