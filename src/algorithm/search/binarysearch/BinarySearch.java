package algorithm.search.binarysearch;

import java.util.Random;

public class BinarySearch {

    public static int indexOfRecursive(int[] array, int key) {
        return indexOfRecursive(array, 0, array.length - 1, key);
    }

    public static int indexOfRecursive(int[] array, int lo, int hi, int key) {
        if (hi < lo)
            return -1;

        int mid = lo + (hi - lo) / 2;

        if (array[mid] == key)
            return mid;
        if (key > array[mid]) {
            return indexOfRecursive(array, mid + 1, hi, key);
        } else {
            return indexOfRecursive(array, lo, mid - 1, key);
        }
    }

    public static int indexOf(int[] array, int key) {
        return indexOf(array, 0, array.length - 1, key);
    }

    public static int indexOf(int[] array, int lo, int hi, int key) {
        if (hi < lo) {
            throw new IllegalArgumentException();
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key == array[mid])
                return mid;
            else if (key > array[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        final int n = 1_000_000;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        int random = new Random().nextInt(n);
        System.out.println(random);
        System.out.println(indexOfRecursive(array, random));

        System.out.println(indexOf(array, random));
        System.out.println(indexOf(array, array[0]));
        System.out.println(indexOf(array, array[array.length - 1]));

    }
}
