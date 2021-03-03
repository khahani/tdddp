package designpattern.strategy.birds;

public abstract class Duck {

  private FlyingBehavior flyingBehavior;
  private QuackingBehavior quackingBehavior;

  public void setFlyingBehavior(FlyingBehavior flyingBehavior) {
    this.flyingBehavior = flyingBehavior;
  }

  public void setQuackingBehavior(QuackingBehavior quackingBehavior) {
    this.quackingBehavior = quackingBehavior;
  }

  public void swim() {
    System.out.println("Swimming");
  }

  public abstract void display();

  public void performFly() {
    flyingBehavior.fly();
  }

  public void performQuack() {
    quackingBehavior.quack();
  }
}
