package designpattern.factory.pizza;

public class NYPizzaIngradientFactory implements PizzaIngradientFactory {
  @Override
  public Dough createDough() {
    return null;
  }

  @Override
  public Sauce createSauce() {
    return null;
  }
}
