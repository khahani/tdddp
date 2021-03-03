package designpattern.strategy.birds.fly;

import designpattern.strategy.birds.FlyingBehavior;

public class CantFly implements FlyingBehavior {
  @Override
  public void fly() {
    System.out.println("I can't fly");
  }
}
