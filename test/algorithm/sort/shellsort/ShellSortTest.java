package algorithm.sort.shellsort;

import algorithm.sort.SortStub;
import org.junit.Assert;
import org.junit.Test;

public class ShellSortTest extends SortStub {
  @Test
  public void sort() {
    int[] array = getUnsorted();

    ShellSort ss = new ShellSort();
    ss.sort(array);

    Assert.assertArrayEquals(getSorted(), array);

  }
}