package algorithm.priorityqueue;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public UnorderedMaxPQ() {
        pq = (Key[]) new Comparable[1];
    }

    public static void main(String[] args) {
        UnorderedMaxPQ<String> pq = new UnorderedMaxPQ<>();
        pq.insert("P");
        pq.insert("Q");
        pq.insert("E");
        System.out.println(pq.delMax());
        pq.insert("X");
        pq.insert("A");
        pq.insert("M");
        System.out.println(pq.delMax());
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key x) {
        if (n == pq.length) {
            resize(2 * n);
        }
        pq[n++] = x;
    }

    private void resize(int capacity) {
        Key[] copy = (Key[]) new Comparable[capacity];
        if (n >= 0) System.arraycopy(pq, 0, copy, 0, n);
        pq = copy;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (less(max, i))
                max = i;
        }
        exch(max, n - 1);
        Key k = pq[--n];
        pq[n] = null;
        if (n == pq.length / 4)
            resize(pq.length / 2);
        return k;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[j] = pq[i];
        pq[i] = swap;
    }
}
