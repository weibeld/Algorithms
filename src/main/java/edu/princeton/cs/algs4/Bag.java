package edu.princeton.cs.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Note: new nodes become the new "first", pointers go from "first" to tail 
public class Bag<Item> implements Iterable<Item> {

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    private Node<Item> first;
    private int n;

    public Bag() {}

    public void add(Item item) {
        Node<Item> node = new Node<Item>();
        node.item = item;
        node.next = first;
        first = node;
        n++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new MyIterator(first);
    }

    public static void main(String[] args) {
        Bag<String> bag = new Bag<String>();
        bag.add("foo");
        bag.add("bar");
        bag.add("baz");
        for (String str : bag) {
            StdOut.println(str);
        }
        StdOut.println("Size: " + bag.size());
    }

    private class MyIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public MyIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

}
