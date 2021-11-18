package algorithm.sort.insertionsort;

import algorithm.sort.SortStub;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest extends SortStub {

  @Test
  public void sort() {

    Integer[] array = getUnsorted();

    InsertionSort insertion = new InsertionSort();
    insertion.sort(array);

    Assert.assertArrayEquals(getSorted(), array);

  }
}