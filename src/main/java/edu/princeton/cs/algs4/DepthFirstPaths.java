package edu.princeton.cs.algs4;

/**
 * Implementation of the single-source path problem: what are the paths from
 * a given source vertex any other vertex?
 * 
 * This implementation performs a depth-first search starting at the given
 * source vertex, and keeps track from which predecessor vertex a vertex has
 * been visited and marked.
 *
 * This results in just some path being returned, not e.g. the shortest path
 * or any other special path.
 */
public class DepthFirstPaths {

    private Graph graph;
    private boolean[] marked;
    private int[] edgeTo;
    private final int source;

    public DepthFirstPaths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        marked = new boolean[graph.getV()];  // Initialised with false
        edgeTo = new int[graph.getV()];      // Initialised with 0
        visit(source);
    }

    private void visit(int v) {
        marked[v] = true;
        for (int w : graph.adj(v))
            if (!marked[w]) {
                edgeTo[w] = v;
                visit(w);
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
