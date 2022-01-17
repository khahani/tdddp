package algorithm.sort.mergesort;

import algorithm.sort.SortAlg;

import java.util.Arrays;

public class MergeSort extends SortAlg {

    public static void main(String[] args) {
        final Integer[] a = {1, 3, 5, 7, 2, 4, 6, 8};
        final Integer[] aux = new Integer[a.length];
        MergeSort ms = new MergeSort();
        ms.merge(a, aux, 0, 3, a.length - 1);
        System.out.println(Arrays.toString(a));

        final Integer[] array = {9, 8, 7, 4, 5, 6, 3, 2, 1};
        ms.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void sort(Comparable[] a) {
        final Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid, hi);

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
}
