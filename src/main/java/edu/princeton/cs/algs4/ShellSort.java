package edu.princeton.cs.algs4;

/**
 * Implementation of shellsort.
 */
public class ShellSort {

    public static void sort(Comparable[] a) {
        // Sequence that can be decremented to 1 by integer-dividing by 3
        int h = 1;
        while (h < a.length/3) h = h*3 + 1;
        // Run "insertion sort" for decreasing values of h (until finally h=1)
        while (h >= 1) {
            for (int i = h; i < a.length; i++)
                for (int c = i; c >= h && less(a[c], a[c-h]); c -= h)
                    exch(a, c, c-h);
            h = h / 3;
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
