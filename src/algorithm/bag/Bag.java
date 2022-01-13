package algorithm.bag;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    private Node first;

    public Bag() {
        first = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private class Node {
        T item;
        Node next;
    }

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(4);
        bag.add(-2);
        bag.add(50);
        bag.add(22);

        for (int i :
                bag) {
            System.out.println(i);
        }
    }
}
