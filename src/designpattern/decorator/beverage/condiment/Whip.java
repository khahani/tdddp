package designpattern.decorator.beverage.condiment;

import designpattern.decorator.beverage.Beverage;
import designpattern.decorator.beverage.CondimentDecorator;

public class Whip extends CondimentDecorator {
  Beverage beverage;

  public Whip(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public String getDescription() {
    return beverage.getDescription() + ", designpattern.decorator.beverage.condiment.Whip";
  }

  @Override
  public double cost() {
    double cost = beverage.cost();
    cost += sizeCost();
    return cost;
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
