package algorithm.queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    public Deque() {
        first = null;
        last = null;
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        if (oldFirst == null)
            last = first;
        else {
            first.next = oldFirst;
            oldFirst.prev = first;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast == null)
            first = last;
        else {
            last.prev = oldLast;
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        Item item = first.item;
        first = first.next;
        if (first != null)
            first.prev = null;
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        size--;

        Item item = last.item;
        last = last.prev;
        if (last == null)
            first = null;
        return item;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {
        addFirstAndRemoveFirst(1);
        addFirstAndRemoveFirst(3);

        addFirstAndRemoveLast(1);
        addFirstAndRemoveLast(3);

        addLastAndRemoveLast(1);
        addLastAndRemoveLast(3);

        addLastAndRemoveFirst(1);
        addLastAndRemoveFirst(3);

    }

    private static void addLastAndRemoveFirst(final int n) {
        Deque<Integer> deque = new Deque<>();
        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());

        for (int i = 0; i < n; i++) {
            deque.addLast(i);
        }

        StdOut.println("isEmpty(): false-" + deque.isEmpty());
        StdOut.println("size(): " + n + ":" + deque.size());

        for (int i = 0; i < n; i++) {
            StdOut.println(deque.removeFirst());
        }

        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());
    }

    private static void addLastAndRemoveLast(final int n) {
        Deque<Integer> deque = new Deque<>();
        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());

        for (int i = 0; i < n; i++) {
            deque.addLast(i);
        }

        StdOut.println("isEmpty(): false-" + deque.isEmpty());
        StdOut.println("size(): " + n + ":" + deque.size());

        for (int i = 0; i < n; i++) {
            StdOut.println(deque.removeLast());
        }

        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());
    }

    private static void addFirstAndRemoveLast(final int n) {
        Deque<Integer> deque = new Deque<>();
        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());

        for (int i = 0; i < n; i++) {
            deque.addFirst(i);
        }

        StdOut.println("isEmpty(): false-" + deque.isEmpty());
        StdOut.println("size(): " + n + ":" + deque.size());

        for (int i = 0; i < n; i++) {
            StdOut.println(deque.removeLast());
        }

        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());
    }

    private static void addFirstAndRemoveFirst(final int n) {
        Deque<Integer> deque = new Deque<>();
        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());

        for (int i = 0; i < n; i++) {
            deque.addFirst(i);
        }

        StdOut.println("isEmpty(): false-" + deque.isEmpty());
        StdOut.println("size(): " + n + ":" + deque.size());

        for (int i = 0; i < n; i++) {
            StdOut.println(deque.removeFirst());
        }

        StdOut.println("isEmpty(): true-" + deque.isEmpty());
        StdOut.println("size(): 0:" + deque.size());
    }
}
