package algorithm.sort.mergesort.interviewquestion;

import java.util.Arrays;

public class SmallerAuxMergeSort {

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable a[], int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable a[], int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        for (int k = lo; k <= mid; k++)
            aux[k] = a[k];

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = a[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(a[j], aux[i]))
                a[k] = a[j++];
            else
                a[k] = aux[i++];
        }

        assert isSorted(a, lo, hi);
    }

    public static void main(String[] args) {
        Comparable[] a = {10, 14, 15, 20, 13, 16, 17, 18};
        Comparable[] aux = new Comparable[a.length / 2];
        int mid = a.length / 2;
        SmallerAuxMergeSort sm = new SmallerAuxMergeSort();
        sm.merge(a, aux, 0, mid - 1, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
