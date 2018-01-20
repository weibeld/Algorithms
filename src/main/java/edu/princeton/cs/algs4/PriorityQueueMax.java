package edu.princeton.cs.algs4;

/**
 * Maximum priority queue implementation using a binay heap.
 */
public class PriorityQueueMax<Key extends Comparable<Key>> {

    private Key[] pq;
    private int indexOfLast = 0;

    public PriorityQueueMax() {
        pq = (Key[]) new Comparable[1000];
    }

    public PriorityQueueMax(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public PriorityQueueMax(Key[] a) {
        pq = (Key[]) new Comparable[a.length + 1];
        for (Key k : a) insert(k);
    }
  
    public void insert(Key k) {
        // Insert new element at end of array, then reheapify the heap.
        pq[++indexOfLast] = k;
        reheapifyUp(indexOfLast);
    }

    public Key removeMax() {
        // Remove root element and replace it with last element of the array,
        // then reheapify the heap.
        Key max = pq[1];
        pq[1] = pq[indexOfLast];
        pq[indexOfLast--] = null;
        reheapifyDown(1);
        return max;
    }

    public Key max() {
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
        pq[j] = pq[i];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // Reheapify bottom-up
    private void reheapifyUp(int i) {
        int parent = parent(i);
        if (!isNode(parent)) return;
        if (less(parent, i)) {
            exch(parent, i);
            reheapifyUp(parent);
        }
    }

    // Reheapify top-down
    private void reheapifyDown(int i) {
        int child1 = child1(i);
        if (!isNode(child1)) return;
        int child2 = child2(i);
        int largerChild = child1;
        if (isNode(child2) && less(child1, child2))
            largerChild = child2;
        if (less(i, largerChild)) {
            exch(i, largerChild);
            reheapifyDown(largerChild);
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
    
}
