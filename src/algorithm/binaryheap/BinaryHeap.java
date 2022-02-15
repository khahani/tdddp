package algorithm.binaryheap;

public class BinaryHeap<Key extends Comparable<Key>> {
    private Key[] data;
    private int n;

    public BinaryHeap() {
        data = (Key[]) new Comparable[2];
    }

    public static void main(String[] args) {
        BinaryHeap<String> binaryHeap = new BinaryHeap<>();
        binaryHeap.insert("P");
        binaryHeap.insert("Q");
        binaryHeap.insert("E");
        System.out.println(binaryHeap.delMax());
        binaryHeap.insert("X");
        binaryHeap.insert("A");
        binaryHeap.insert("M");
        System.out.println(binaryHeap.delMax());
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Key delMax() {
        Key max = data[1];
        exch(1, n--);
        sink(1);
        data[n + 1] = null;
        if (n == data.length / 4)
            resize(data.length / 2);
        return max;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void insert(Key x) {
        if (n == data.length - 1)
            resize(2 * data.length);
        data[++n] = x;
        swim(n);
    }

    private void resize(int capacity) {
        Key[] copy = (Key[]) new Comparable[capacity];
        System.arraycopy(data, 0, copy, 0, n + 1);
        data = copy;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return data[i].compareTo(data[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = data[i];
        data[i] = data[j];
        data[j] = swap;
    }
}
