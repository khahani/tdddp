package designpattern.strategy.birds.quack;

import designpattern.strategy.birds.QuackingBehavior;

public class Quack implements QuackingBehavior {
  @Override
  public void quack() {
    System.out.println("Quack");
  }
}
