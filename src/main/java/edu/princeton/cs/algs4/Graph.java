package edu.princeton.cs.algs4;

import java.util.Iterator;
import java.io.File;

// Representation of an undirected and unweighted graph.
public class Graph {

    private final int nV;       // Number of vertices
    private int nE;             // Number of edges
    private Bag<Integer>[] adj; // Adjacency lists

    public Graph(int nV) {
        this.nV = nV;
        nE = 0;
        adj = (Bag<Integer>[]) new Bag[nV];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new Bag<Integer>();
    }

    public Graph(In in) {
        this(in.readInt());  // Call other constructor
        int tmp = in.readInt();
        for (int i = 0; i < tmp; i++)
            addEdge(in.readInt(), in.readInt());
    }

    public int getE() {
        return nE;
    }

    public int getV() {
        return nV;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        nE++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nV + " vertices, " + nE + " edges\n");
        for (int i = 0; i < adj.length; i++) {
            sb.append(i + ": ");
            for (int e : adj[i])
                sb.append(e + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

    // If no command-line arg given, enter graph on stdin in the same format as
    // the graph files. If command-line arg (filename) is given, the graph is
    // read from this file.
    public static void main(String[] args) {
        Graph g;
        if (args.length == 0)
            g = new Graph(new In());
        else
            g = new Graph(new In(new File(args[0])));
        StdOut.print(g.toString());
    }
}
