package edu.princeton.cs.algs4;

import java.util.Arrays;

/**
 *  The {@code LinearSearch} class provides a static method for brute-force
 *  searching for an integer in a possibly unsorted array of integers.
 *  <p>
 *  The <em>indexOf</em> operations takes linear time in the worst case.
 *  <p>
 *
 *  @author Daniel Weibel
 */
public class LinearSearch {

    private LinearSearch() { }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param  a the array of integers, may be unsorted
     * @param  key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }        
        return -1;
    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument; reads in integers from standard input;
     * prints to standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (LinearSearch.indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
    }
}

