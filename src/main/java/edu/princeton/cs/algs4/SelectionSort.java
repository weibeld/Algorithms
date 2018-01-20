package edu.princeton.cs.algs4;

/**
 * Implementation of selection sort.
 *
 * - Number of comparisons: (N^2)/2
 * - Number of exchanges: N
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static void sortRecursive(Comparable[] a, int start) {
        // A sorted subarray is the smallest item from the interval [start..end]
        // at index 'start', plus the sorted subarray [start+1..end].
        if (start == a.length-1) return;
        else {
            int min = start;
            for (int i = start+1; i < a.length; i++)
                if (less(a[i], a[min])) min = i;
            exch(a, start, min);
            sortRecursive(a, start+1);
        }
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
        assert isSorted(a);

        show(a); 
    }
}
