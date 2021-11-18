package algorithm.sort;

public class SortStub {
  private Integer[] array = new Integer[]{15, 1, -22, 20, -9, 2};
  private Integer[] expected = new Integer[]{-22, -9, 1, 2, 15, 20};


  public Integer[] getUnsorted() {
    return array;
  }

  public Integer[] getSorted() {
    return expected;
  }
}
