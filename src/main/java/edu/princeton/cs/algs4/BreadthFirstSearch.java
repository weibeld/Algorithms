package edu.princeton.cs.algs4;

/**
 * Implementation of breadt-first search (BFS): visit and mark all the vertices
 * that are connected to a given source vertex.
 */
public class BreadthFirstSearch {

    private Graph graph;
    private int source;
    private boolean[] marked;
    
    public BreadthFirstSearch(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        marked = new boolean[graph.getV()];
        bfs();
    }

    private void bfs() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(source);
        while (!q.isEmpty()) {
            int current = q.dequeue();
            marked[current] = true;
            for (int v : graph.adj(current))
                if (!marked[v]) q.enqueue(v);
        }
        
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
