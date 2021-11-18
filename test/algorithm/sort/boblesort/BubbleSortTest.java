package algorithm.sort.boblesort;

import algorithm.sort.SortStub;
import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest extends SortStub {

  @Test
  public void sort() {

    Integer[] array = getUnsorted();

    BubbleSort bs = new BubbleSort();
    bs.sort(array);

    Assert.assertArrayEquals(getSorted(), array);

  }

}
