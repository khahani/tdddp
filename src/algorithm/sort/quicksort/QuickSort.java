package algorithm.sort.quicksort;

import algorithm.sort.SortAlg;
import algorithm.sort.Sortable;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class QuickSort extends SortAlg implements Sortable {
    private static final int CUTTOFF = 10;

    public static void main(String[] args) {
        Integer[] a = new Integer[]{3, 4, 5, 1, 2, 6, 9, 8, 7};
        Integer[] s = a.clone();
        QuickSort qs = new QuickSort();
        qs.sort(a);
        System.out.println(Arrays.toString(a));
        Integer selected = (Integer) qs.select(s, 0);
        System.out.println("Selected: " + selected);
    }

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo + CUTTOFF - 1) {
            Insertion.sort(a, lo, hi + 1);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;

        while (true) {

            while (less(a[++i], a[lo]))
                if (i == hi) break;

            while (less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j)
                break;

            exch(a, i, j);
        }

        exch(a, j, lo);
        return j;
    }

    public Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];
    }

}
