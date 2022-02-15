package algorithm.binaryheap;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{0, 4, 2, 1, 3, 5, 8, 9, 7, 6};
        Heap h = new Heap();
        h.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) sink(a, k, n);
        int k = n;
        while (k > 1) {
            exch(a, 1, k--);
            sink(a, 1, k);
        }
    }

    private void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }
}
