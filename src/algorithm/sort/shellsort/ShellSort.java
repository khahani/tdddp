package algorithm.sort.shellsort;

import algorithm.sort.SortAlg;

import java.util.Arrays;

public class ShellSort extends SortAlg {

    public void sort(Integer[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];

                int j = i;

                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }

        }
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        int h = 1;
        while (h < N / 3) h = 3 * h + 1; //1, 4, 13, 40, 121, 364, ...

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
        }

    }

    public static void main(String[] args) {
        Integer[] array = {4, 5, 2, -1, 0, 8};
        new ShellSort().sort(array);
        Arrays.asList(array).forEach(System.out::println);
    }
}
