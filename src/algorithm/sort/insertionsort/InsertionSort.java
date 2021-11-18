package algorithm.sort.insertionsort;

import algorithm.sort.SortAlg;

/*
    Preposition: To sort a randomly-ordered array with distinct keys,
    insertion sort uses ~1/4 N^2 compares, and ~1/4 N^2 exchanges on average.

    Pf. Expect each entry to move halfway back

    Best case: If the array is in ascending order, insertion sort makes
    N-1 compares and 0 exchange

    Worst case: If the array is descending order (and no duplicates),
    insertion sort makes ~1/2 N^2 compares, and ~1/2 N^2 exchanges.

    Partially-sorted arrays:
    Def. An inversion is a pair of keys that are out of order.
    Def. An array is partially-sorted if the number of inversions is <=cN.

    Preposition. For partially-sorted arrays, insertion sort runs in linear time.
    Pf. Number of exchanges equals the number of inversions.
            number of compares = exchanges+(N-1)
 */
public class InsertionSort extends SortAlg {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
            }
        }
    }
}
