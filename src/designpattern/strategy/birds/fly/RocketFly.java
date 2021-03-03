package designpattern.strategy.birds.fly;

import designpattern.strategy.birds.FlyingBehavior;

public class RocketFly implements FlyingBehavior {
  @Override
  public void fly() {
    System.out.println("Flying with rocket");
  }
}
