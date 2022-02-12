package algorithm.sort.quicksort;

import algorithm.sort.SortAlg;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Quick3Way extends SortAlg {
    public static void main(String[] args) {
        Character[] a = new Character[]{'R', 'B', 'W', 'W', 'R', 'W', 'B', 'R', 'R', 'W', 'B', 'R'};
        Quick3Way q3 = new Quick3Way();
        q3.sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
}
