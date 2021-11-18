package algorithm.sort.selectionsort;

import algorithm.sort.SortAlg;

/*
    Proposition: Selection sort uses (N-1)+(N-2)+...+2+1+0~ N^2/2 compares
    and N exchanges.
 */
public class Selection extends SortAlg {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
        }
    }
}
