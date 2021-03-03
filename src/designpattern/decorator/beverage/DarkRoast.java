package designpattern.decorator.beverage;

public class DarkRoast extends Beverage {

  public DarkRoast() {
    description = "Dark Roast coffee";
  }

  @Override
  public double cost() {
    return .99 + sizeCost();
  }

  @Override
  protected double sizeCost() {
    switch (getSize()) {
      case Beverage.TALL:
        return .1;
      case Beverage.GRANDE:
        return .15;
      case Beverage.VENII:
        return .20;
    }
    return .0;
  }
}
