package designpattern.decorator.beverage;

public class HouseBlend extends Beverage {

  public HouseBlend() {
    description = "House Blend Coffee";
  }

  @Override
  public double cost() {
    return .89 + sizeCost();
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
