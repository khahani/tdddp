package algorithm.sort.boblesort;

public class BobleSort {

  public void sort(int[] array) {
    for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
      for (int i = 0; i < lastUnsortedIndex; i++) {
        if (array[i] > array[i + 1])
          swap(array, i, i + 1);
      }
    }
  }

  private void swap(int[] array, int i, int j) {
    if (array[i] == array[j])
      return;

    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
