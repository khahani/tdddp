package algorithm.sort.mergesorts;

import algorithm.sort.SortAlg;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort extends SortAlg {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();

        final Integer[] b = {2, 1};
        ms.sort(b);
        System.out.println(Arrays.toString(b));

        final Integer[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        final Integer[] aux = new Integer[a.length];
        ms.merge(a, aux, 0, 3, a.length - 1);
        System.out.println(Arrays.toString(a));

        final Integer[] array = {9, 8, 7, 4, 5, 6, 3, 2, 1};
        ms.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi);
    }

    private void merge(Object[] a, Object[] aux, Comparator c, int lo, int mid, int hi) {
        assert isSorted(c, a, lo, mid);
        assert isSorted(c, a, mid + 1, hi);

        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(c, aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }

        assert isSorted(c, a, lo, hi);
    }


    @Override
    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public void sort(Object[] a, Comparator c) {
        Object[] aux = new Object[a.length];
        sort(a, aux, c, 0, a.length - 1);
    }

    private void sort(Object[] a, Object[] aux, Comparator c, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, c, lo, mid);
        sort(a, aux, c, mid + 1, hi);
        merge(a, aux, c, lo, mid, hi);
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
}
