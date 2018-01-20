package edu.princeton.cs.algs4;

/**
 * Implementation of quicksort
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        sortRecursive(a, 0, a.length-1);
    }

    private static void sortRecursive(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int pivot = partition(a, lo, hi);
        sortRecursive(a, lo, pivot-1);
        sortRecursive(a, pivot+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[hi];
        int rightmostOfLeft = lo - 1;  // Rightmost element of the "smaller than pivot" partition
        for (int i = lo; i < hi; i++)
            // When we encounter a "smaller than pivot" element, move it to the "smaller than pivot" partition
            if (less(a[i], pivot)) {
                rightmostOfLeft++;  // Make "smaller than pivot" partition bigger
                exch(a, rightmostOfLeft, i); // As long as all elements are < pivot, rightmostOfLeft == i
            }
        // Move pivot to final position and return its index
        exch(a, hi, rightmostOfLeft + 1);
        return rightmostOfLeft + 1;
    }


    // Test if each element is less than or equal to its subsequent element
    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++)
            if (!leq(a[i], a[i+1])) return false;
        return true;
    }

    // Test if v is less than or equal to w
    private static boolean leq(Comparable v, Comparable w) {
        int x = v.compareTo(w);
        return x < 0 || x == 0;
    }

    // Test if v is less than w
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Swap the elements at indices i and j
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // Print array on one line
    private static void show(Comparable[] a) {
        for (Comparable c : a) StdOut.print(c + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        show(a);

        sort(a);
        //sortRecursive(a, 0);

        show(a); 
        assert isSorted(a) : "Not correctly sorted";
    }
}
