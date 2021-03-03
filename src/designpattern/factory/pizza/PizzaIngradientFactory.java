package designpattern.factory.pizza;

public interface PizzaIngradientFactory {
  Dough createDough();

  Sauce createSauce();

}
