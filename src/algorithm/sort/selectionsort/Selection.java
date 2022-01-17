package algorithm.sort.selectionsort;

import algorithm.sort.SortAlg;

import java.util.Arrays;

/*
    Proposition: Selection sort uses (N-1)+(N-2)+...+2+1+0~ N^2/2 compares
    and N exchanges.
    Running time insensitive to input: Quadratic time, even if input is sorted.
    Data movement is minimal: Linear number of exchange
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

    public static void main(String[] args) {
        Integer[] array = {4, 5, 2, -1, 0, 8};
        new Selection().sort(array);
        Arrays.asList(array).forEach(System.out::println);
    }
}
