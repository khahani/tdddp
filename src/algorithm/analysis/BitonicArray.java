package algorithm.analysis;

public class BitonicArray {

    private final int bitonic;
    private final int[] array;

    public BitonicArray(int[] array) {
        bitonic = findBitonic(array);
        this.array = array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-5, 2, 6, 8, 120, 119, 114, 87, 0, -3, -10, -20};

        int bitonic = findBitonic(array);
        int bitnoicR = findBitonic(array, 0, array.length - 1);

        System.out.println(array[bitonic]);
        System.out.println(array[bitnoicR]);

        BitonicArray bt = new BitonicArray(array);
        int index = bt.indexOf(13);
        if (index < 0)
            System.out.println("Not found");
        else
            System.out.println(array[index]);
    }

    private static int findBitonic(int[] array) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return mid;
            } else if (array[mid] > array[mid - 1] && array[mid] < array[mid + 1]) {
                lo = mid;
            } else if (array[mid] < array[mid - 1] && array[mid] > array[mid + 1]) {
                hi = mid;
            }
        }
        return -1;
    }

    private static int findBitonic(int[] array, int lo, int hi) {

        int mid = lo + (hi - lo) / 2;
        if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
            return mid;
        } else if (array[mid] > array[mid - 1] && array[mid] < array[mid + 1]) {
            return findBitonic(array, mid, hi);
        } else if (array[mid] < array[mid - 1] && array[mid] > array[mid + 1]) {
            return findBitonic(array, lo, mid);
        } else
            return -1;
    }

    private int indexOfAscending(int lo, int hi, int key) {
        if (lo > hi)
            return -1;

        int mid = lo + (hi - lo) / 2;
        if (key == array[mid])
            return mid;
        if (key > array[mid])
            return indexOfAscending(mid + 1, hi, key);
        else
            return indexOfAscending(lo, mid - 1, key);
    }

    private int indexOfDescending(int lo, int hi, int key) {
        if (lo > hi)
            return -1;

        int mid = lo + (hi - lo) / 2;
        if (key == array[mid])
            return mid;
        else if (key > array[mid])
            return indexOfDescending(lo, mid - 1, key);
        else
            return indexOfDescending(mid + 1, hi, key);
    }

    public int indexOf(int key) {
        if (key == array[bitonic])
            return bitonic;

        int index = indexOfAscending(0, bitonic, key);

        if (index != -1)
            return index;
        else
            return indexOfDescending(bitonic, array.length - 1, key);

    }
}
