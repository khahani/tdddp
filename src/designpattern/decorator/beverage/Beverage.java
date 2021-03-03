package designpattern.decorator.beverage;

public abstract class Beverage {
  public static final int NONE = 0;
  public static final int TALL = 1;
  public static final int GRANDE = 2;
  public static final int VENII = 3;
  protected Beverage beverage;
  String description = "Unknown Beverage";
  int size = NONE;

  public String getDescription() {
    return description;
  }

  public abstract double cost();

  protected abstract double sizeCost();

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
