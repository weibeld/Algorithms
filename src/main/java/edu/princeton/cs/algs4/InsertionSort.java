package edu.princeton.cs.algs4;

/**
 * Implementation of insertion sort.
 *
 * - Number of comparisons: (N^2)/2
 * - Number of exchanges: N
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            for(int c = i; c > 0 && less(a[c], a[c-1]); c--)
                exch(a, c, c-1);
    }

    // Recursive implementation of insertion sort. For the initial call, 'end'
    // is the index of the last element of the array.
    public static void sortRecursive(Comparable[] a, int end) {
        if (a.length == 1) return;
        sortRecursive(a, end-1);
        for(int c = end; c > 0 && less(a[c], a[c-1]); c--)
            exch(a, c, c-1);
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

        //sort(a);
        sortRecursive(a, a.length-1);

        show(a); 
        assert isSorted(a) : "Not correctly sorted";
    }
}
