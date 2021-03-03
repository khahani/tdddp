package designpattern.adapter.duck;

public class MallardDuck implements Duck {
  @Override
  public void quake() {
    System.out.println("Quake");
  }

  @Override
  public void fly() {
    System.out.println("i'm flying");
  }
}
