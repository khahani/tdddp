package algorithm.sort.boblesort;

import org.junit.Assert;
import org.junit.Test;

public class BobleSortTest {


  @Test
  public void sort() {
    int[] array = new int[]{15, 1, -22, 20, -9, 2};
    int[] expected = new int[]{-22, -9, 1, 2, 15, 20};

    BobleSort bs = new BobleSort();
    bs.sort(array);

    Assert.assertArrayEquals(expected, array);

  }

}
