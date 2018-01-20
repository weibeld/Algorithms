package edu.princeton.cs.algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Note: new nodes become the new "head", pointers go from "head" to last 
public class Stack<Item> implements Iterable<Item> {

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    Node<Item> head;
    int size;

    public Stack() {}

    public void push(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Attempting to pop from an empty stack");
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Attempting to pop from an empty stack");
        return head.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator<Item>(head);
    }

    public static void main(String[] args) {
        simpleClient();
    }

    private class MyIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public MyIterator(Node<Item> head) {
            current = head;
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

    // Push some items on a stack, print each item of the stack (most recently
    // pushed item first), and pop some items.
    static private void simpleClient() {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty())
            stack.push(StdIn.readString());
        printStack(stack);
        StdOut.println("size = " + stack.size());
        String item;
        item = stack.pop();
        StdOut.println("pop " + item + ", now size is " + stack.size());
        item = stack.pop();
        StdOut.println("pop " + item + ", now size is " + stack.size());
        printStack(stack);
    }

    // Traverse stack in its natural order (most recent item first), and print
    static private void printStack(Stack<String> stack) {
        for (String item : stack)
            StdOut.println(item);
    }

    @Override
    public String toString() {
        Iterator<Item> it = iterator();
        StringBuilder s = new StringBuilder();
        while (it.hasNext()) s.append(it.next() + "\n");
        return s.toString();
    }

}
