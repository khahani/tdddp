package algorithm.queue;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int head;
    private int tail;

    public RandomizedQueue() {
        array = (Item[]) new Object[1];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();

        array[tail++] = item;
        if (tail == array.length)
            resize(2 * array.length);
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        int newTail = 0;
        for (int i = 0; i < tail; i++) {
            if (array[i] != null) {
                copy[newTail] = array[i];
                newTail++;
            }
        }
        array = copy;
        head = 0;
        tail = newTail;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();

        final int randomIndex = StdRandom.uniform(head, tail);
        Item item = array[randomIndex];
        array[randomIndex] = array[head];
        array[head] = null;
        head++;
        if (Math.abs(head - tail) == array.length / 4)
            resize(array.length / 2);
        return item;
    }

    public int size() {
        return Math.abs(head - tail);
    }

    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException();

        int randomIndex = StdRandom.uniform(head, tail);
        return array[randomIndex];
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        StdOut.println(q.isEmpty());
        q.enqueue(1);
        StdOut.println("size:" + q.size());
        StdOut.println(q.dequeue());
        StdOut.println(q.isEmpty());


        for (int i = 0; i < 50; i++) {
            q.enqueue(i);
        }
        StdOut.println("size:" + q.size());
        for (int i = 0; i < 20; i++) {
            StdOut.println("Random: " + q.sample());
        }
        for (int i = 0; i < 50; i++) {
            StdOut.println(q.dequeue());
        }
        StdOut.println("size:" + q.size());

        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }
        int count = 0;
        for (int item : q) {
            StdOut.println("Random#" + count + ": " + item);
            count++;
        }
        StdOut.println("size: " + q.size());
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private final Item[] copy;
        private int offset = 0;

        private RandomizedQueueIterator() {
            copy = (Item[]) new Object[size()];
            int j = 0;
            for (int i = head; i < tail; i++) {
                copy[j] = array[i];
                j++;
            }
            StdRandom.shuffle(copy, 0, copy.length);
        }

        @Override
        public boolean hasNext() {
            return offset != copy.length;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy[offset++];
        }
    }
}
