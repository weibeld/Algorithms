package edu.princeton.cs.algs4;

/**
 * Implementation of bottom-up mergesort.
 */
public class MergeSortBottomUp {

    // Hold copy of the portions of the array being merged
    private static Comparable[] copy;  // Declare array

    public static void sort(Comparable[] a) {
        copy = new Comparable[a.length];  // Create array
        // Merge sorted sub-arrays of size s to sorted subarrays of size s*2
        for (int s = 1; s < a.length; s *= 2)
            for (int lo = 0; lo < a.length - s; lo += s*2)
                // The right half might be smaller than s, so we need Math.min
                merge(a, lo, lo+s-1, Math.min(lo + s*2 - 1, a.length-1));
    }

    // Merge a sorted left half (a[lo..mid]) and right half (a[mid+1..hi]) of a
    // portion of an array, resulting in the array portion a[lo..hi] sorted.
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Make copy of a[lo..hi]
        for (int i = lo; i <= hi; i++) copy[i] = a[i];  // Initialise array
        int left = lo;      // Next smallest element of the left half
        int right = mid+1;  // Next smallest element of the right half
        for (int i = lo; i <= hi; i++) {
            if      (left > mid)                   a[i] = copy[right++];  // No  more elements in left half
            else if (right > hi)                   a[i] = copy[left++];   // No more elements in right half
            else if (leq(copy[left], copy[right])) a[i] = copy[left++];   // Element from left half is <=
            else                                   a[i] = copy[right++];  // Element from left half is <
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

        show(a); 
        assert isSorted(a) : "Not correctly sorted";
    }
}
