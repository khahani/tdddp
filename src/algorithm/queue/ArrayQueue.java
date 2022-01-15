package algorithm.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> {
    private T[] array;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        array = (T[]) new Object[1];
        head = 0;
        tail = 0;
    }


    public static void main(String[] args) {

    }


    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(T item) {
        array[tail++] = item;
        if (tail == array.length)
            resize(2 * array.length);
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        int newTail = 0;
        for (int i = 0, j = 0; i < tail; i++) {
            if (array[i] != null) {
                copy[j] = array[i];
                j++;
                newTail++;
            }
        }
        array = copy;
        head = 0;
        tail = newTail;
    }

    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        T item = array[head];
        array[head] = null;
        head++;
        if (Math.abs(head - tail) == array.length / 4)
            resize(array.length / 2);
        return item;
    }
}
