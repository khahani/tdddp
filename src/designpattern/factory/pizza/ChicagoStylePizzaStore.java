package designpattern.factory.pizza;

public class ChicagoStylePizzaStore extends PizzaStore {
  @Override
  protected Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new ChicagoCheesePizza();
    }
    if (type.equals("pepperoni")) {
      return new ChicagoPepperoniPizza();
    }
    if (type.equals("clam")) {
      return new ChicagoClamPizza();
    }
    return null;
  }
}
