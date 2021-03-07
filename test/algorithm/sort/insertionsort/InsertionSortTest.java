package algorithm.sort.insertionsort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

  @Test
  public void sort() {
    int[] array = new int[]{15, 1, -22, 20, -9, 2};
    int[] expected = new int[]{-22, -9, 1, 2, 15, 20};

    InsertionSort insertion = new InsertionSort();
    insertion.sort(array);

    Assert.assertArrayEquals(expected, array);

  }
}