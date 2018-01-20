package edu.princeton.cs.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Note: new nodes become the new "last", pointers go from "first" to "last"
public class Queue<Item> implements Iterable<Item> {

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    Node<Item> first;
    Node<Item> last;
    int size;

    public Queue() {}

    public void enqueue(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        if (!isEmpty()) last.next = newNode;
        else            first = newNode;
        last = newNode;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Attempting to dequeue from an empty queue");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator<Item>(first);
    }

    public static void main(String[] args) {
        simpleClient();
    }

    private class MyIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public MyIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    static private void simpleClient() {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty())
            queue.enqueue(StdIn.readString());
        for (String s : queue)
            StdOut.println(s);
        StdOut.println("size = " + queue.size());
        String item;
        item = queue.dequeue();
        StdOut.println("dequeue " + item + ", now size is " + queue.size());
        item = queue.dequeue();
        StdOut.println("dequeue " + item + ", now size is " + queue.size());
    }

}
