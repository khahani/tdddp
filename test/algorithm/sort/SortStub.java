package algorithm.sort;

public class SortStub {
  private int[] array = new int[]{15, 1, -22, 20, -9, 2};
  private int[] expected = new int[]{-22, -9, 1, 2, 15, 20};


  public int[] getUnsorted() {
    return array;
  }

  public int[] getSorted() {
    return expected;
  }
}
