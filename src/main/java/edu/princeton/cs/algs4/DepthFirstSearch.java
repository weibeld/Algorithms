package edu.princeton.cs.algs4;

/**
 * Implementation of depth-first search (DFS): visit and mark all the connected
 * vertices from a given source vertex.
 */
public class DepthFirstSearch {

    private Graph graph;
    private boolean[] marked;

    public DepthFirstSearch(Graph graph, int source) {
        this.graph = graph;
        marked = new boolean[graph.getV()];  // Initialised with false
        visit(source);
    }

    private void visit(int v) {
        marked[v] = true;
        for (int i : graph.adj(v))
            if (!marked[i]) visit(i);
    }

    // Test if the supplied vertex is connected to the source vertex
    public boolean marked(int v) {
        return marked[v];
    }

    // Get the number of vertices that are connected to the source vertex
    // (this number includes the source vertx itself)
    public int count() {
        int c = 0;
        for (boolean v : marked)
            if (v) c++;
        return c;
    }
}
