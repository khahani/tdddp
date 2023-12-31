package algorithm.sort;

import java.util.Comparator;

public abstract class SortAlg implements Sortable {

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static boolean isSorted(Comparator c, Object[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(c, a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {-4, -1, 2, 3, 4};
        System.out.println(isSorted(a, 0, a.length));
    }
}
