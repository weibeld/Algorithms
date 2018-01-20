package edu.princeton.cs.algs4;

import edu.princeton.cs.algs4.StdOut;
 
public class Counter {

    private String id;
    private int tally;

    public Counter(String id) {
        this.id= id;
    }

    public void increment() {
        assert tally >= 0;
        tally++;
    }

    public int tally() {
        return tally;
    }

    public String toString() {
        return tally + " " + id;
    }

    public static void main(String[] args) {
        Counter c = new Counter("hits");
        StdOut.println(c.tally);
        c.increment();
        StdOut.println(c.tally);
        c.increment();
        StdOut.println(c.tally);
        c.increment();
        StdOut.println(c.tally);
        StdOut.println(c);
    }

}
