package edu.princeton.cs.algs4;

/**
 * Minimum priority queue implementation using a binay heap.
 */
public class PriorityQueueMin<Key extends Comparable<Key>> {

    private Key[] pq;
    private int indexOfLast = 0;

    public PriorityQueueMin() {
        pq = (Key[]) new Comparable[1000];
    }

    public PriorityQueueMin(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public PriorityQueueMin(Key[] a) {
        pq = (Key[]) new Comparable[a.length + 1];
        for (Key k : a) insert(k);
    }
  
    public void insert(Key k) {
        // Insert new element at end of array, then reheapify the heap.
        pq[++indexOfLast] = k;
        reheapifyUp(indexOfLast);
    }

    public Key removeMin() {
        // Remove root element and replace it with last element of the array,
        // then reheapify the heap.
        Key min = pq[1];
        pq[1] = pq[indexOfLast];
        pq[indexOfLast--] = null;
        reheapifyDown(1);
        return min;
    }

    public Key min() {
        return pq[1];
    }

    public boolean isEmpty() {
        return indexOfLast == 0;
    }

    public int size() {
        return indexOfLast;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // Reheapify bottom-up
    private void reheapifyUp(int i) {
        int parent = parent(i);
        if (!isNode(parent)) return;
        if (less(i, parent)) {
            exch(i, parent);
            reheapifyUp(parent);
        }
    }

    // Reheapify top-down
    private void reheapifyDown(int i) {
        int child1 = child1(i);
        if (!isNode(child1)) return;
        int child2 = child2(i);
        int smallerChild = child1;
        if (isNode(child2) && less(child2, child1))
            smallerChild = child2;
        if (less(smallerChild, i)) {
            exch(smallerChild, i);
            reheapifyDown(smallerChild);
        }
    }

    // Get the index of the parent node of the node with index i
    private int parent(int i) {
        return i / 2;
    }

    // Get the index of the first and second child of a node with index i
    private int child1(int i) {
        return i * 2;
    }
    private int child2(int i) {
        return i * 2 + 1;
    }

    // Check if an index points to a valid node of the heap
    private boolean isNode(int i) {
        return i >= 1 && i <= indexOfLast;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= indexOfLast; i++)
            s.append(pq[i].toString() + "\n");
        return s.toString();
    }

    // Development client (for testing implementation)
    public static void main(String[] args) {
        PriorityQueueMin<Integer> q = new PriorityQueueMin<Integer>(10);
        java.util.Scanner s = new java.util.Scanner(System.in);
        while (s.hasNextInt()) {
            q.insert(s.nextInt());
            StdOut.println("Priority queue: \n" + q);
        }
    }
    
}
