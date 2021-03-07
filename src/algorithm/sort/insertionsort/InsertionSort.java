package algorithm.sort.insertionsort;

public class InsertionSort {

  public void sort(int[] array) {
    for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
      int newElement = array[firstUnsortedIndex];

      int i;

      for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
        array[i] = array[i - 1];
      }

      array[i] = newElement;
    }
  }
}
