package designpattern.strategy.birds;

import designpattern.strategy.birds.fly.FlyWithWinds;
import designpattern.strategy.birds.fly.RocketFly;
import designpattern.strategy.birds.quack.Quack;

public class Program {
  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.setFlyingBehavior(new FlyWithWinds());
    mallard.setQuackingBehavior(new Quack());
    mallard.performFly();
    mallard.display();
    mallard.performQuack();

    Duck rocket = new RockDuck();
    rocket.setFlyingBehavior(new RocketFly());
    rocket.performFly();
  }
}
