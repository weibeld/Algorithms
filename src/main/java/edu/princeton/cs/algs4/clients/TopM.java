package edu.princeton.cs.algs4.clients;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.PriorityQueueMin;
import edu.princeton.cs.algs4.Stack;

/**
 * Client application for PriorityQueueMin.
 *
 * Read integers from stdin and retain the highest m ones (m is supplied as a
 * command line argument).
 *
 * After reading every integer, prints out the top m integers "so far".
 *
 * After reading all the integer, prints out the final top m integers in
 * decreasing order.
 *
 * The idea to determine the highest m values form a very large set of values,
 * or possibly non-terminating stream of values, is to use a minimum priority
 * queue of size m+1. Whenever an m+1st item is inserted into the priority
 * queue, the smallest of these items is removed, so that only the largest m of
 * these items remain in the priority queue. The removal of the smallest item
 * can be trivially done with the removeMin operatio of the min priority queue.
 */
public class TopM {

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        PriorityQueueMin<Integer> pq = new PriorityQueueMin(m+1);
        while (StdIn.hasNextLine()) {
            int val = Integer.parseInt(StdIn.readLine());
            StdOut.println("Reading " + val);
            pq.insert(val);
            if (pq.size() > m) {
                pq.removeMin();
                StdOut.println("Top " + m + " so far are (unordered):\n" + pq);
            }
        }
        // Get the top m ints in order (smallest first), and reverse this order
        Stack<Integer> stack = new Stack<Integer>();
        while (!pq.isEmpty())
            stack.push(pq.removeMin());
        StdOut.println("The final top " + m + " are:\n" + stack);
    }
}

