package algorithm.shift;

import java.util.Arrays;

public class ShiftArray {
    public static void main(String[] args) {

        final long start = System.currentTimeMillis();
        final int i = 5000000;
        final int n = 10000000;
        int[] a = new int[n];
        for (int j = 0; j < n; j++) {
            a[j] = j;
        }
        shiftLeft(a, i);
        final long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(a));
        System.out.println("time: " + (end - start) + "ms");
    }

    private static void shiftLeft(int[] a, int i) {
        final int n = a.length;
        shiftLeft(a, n, i);
    }

    private static void shiftLeft(int[] a, int to, int i) {
        if (to - i < 0) return;
        for (int j = 0; j < i; j++) {
            int temp = a[j];
            a[j] = a[to - i + j];
            a[to - i + j] = temp;
        }
        shiftLeft(a, to - i, i);
    }

    private static void shiftRight(int[] a, int i) {
        shiftRight(a, 0, i);
    }

    private static void shiftRight(int[] a, int from, int i) {
        final int n = a.length;
        if (from + i > n) return;
        for (int j = 0; j < i; j++) {
            int temp = a[n - i + j];
            a[n - i + j] = a[from + j];
            a[from + j] = temp;
        }
        shiftRight(a, from + i, i);
    }
}
