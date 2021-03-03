package designpattern.factory.pizza;

public class NYStylePizzaStore extends PizzaStore {
  @Override
  protected Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new NyCheesePizza();
    }
    if (type.equals("pepperoni")) {
      return new NyPepperoniPizza();
    }
    return null;
  }
}
