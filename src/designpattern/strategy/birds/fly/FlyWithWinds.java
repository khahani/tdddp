package designpattern.strategy.birds.fly;

import designpattern.strategy.birds.FlyingBehavior;

public class FlyWithWinds implements FlyingBehavior {
  @Override
  public void fly() {
    System.out.println("Fly with winds");
  }
}
