package algorithm.sort.mergesort;

import algorithm.sort.SortAlg;

import java.util.Arrays;

public class MergeSortBottomUp extends SortAlg {
    private static Comparable[] aux;

    public static void main(String[] args) {
        MergeSortBottomUp ms = new MergeSortBottomUp();

        final Integer[] b = {2, 1};
        ms.sort(b);
        System.out.println(Arrays.toString(b));

        final Integer[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        aux = new Integer[a.length];
        ms.merge(a, 0, 3, a.length - 1);
        System.out.println(Arrays.toString(a));

        final Integer[] array = {9, 8, 7, 4, 5, 6, 3, 2, 1};
        ms.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void sort(Comparable[] a) {
        final int n = a.length;
        aux = new Comparable[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
        }

    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi);
    }
}
