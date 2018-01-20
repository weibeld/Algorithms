package edu.princeton.cs.algs4;

/**
 * Implementation of the single-source path problem: what are the paths from
 * a given source vertex to all other connected vertices?
 * 
 * This implementation uses a breadth-first search (BFS) This has the effect
 * that the SHORTEST PATHS from the source vertex to all the other connected
 * vertices are found.
 */
public class BreadthFirstPaths {

    private Graph graph;
    private int source;
    private boolean[] marked;
    private int[] edgeTo;
    
    public BreadthFirstPaths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        bfs();
    }

    private void bfs() {
        Queue<Integer> q = new Queue<>();
        marked[source] = true;
        q.enqueue(source);
        while (!q.isEmpty()) {
            int current = q.dequeue();
            StdOut.println(current);
            for (int v : graph.adj(current))
                if (!marked[v]) {
                    marked[v] = true;
                    edgeTo[v] = current;
                    q.enqueue(v);
                }
        }
        
    }

    public boolean hasPathTo(int target) {
        return marked[target];
    }

    public Iterable<Integer> getPathTo(int target) {
        if (!hasPathTo(target)) return null;
        // Put vertices from target to source on a stack, so that the client
        // can retrieve them in the reverse order (from source to target)
        Stack<Integer> stack = new Stack<>();
        for (int node = target; node != source; node = edgeTo[node])
            stack.push(node);
        stack.push(source);
        return stack;
    }
}
