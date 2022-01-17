package algorithm.shuffle;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        final int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = new Random().nextInt(i + 1);
            exch(a, i, r);
        }
        Arrays.asList(a).forEach(System.out::println);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
