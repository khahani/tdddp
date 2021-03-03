package designpattern.factory.pizza;

public class Program {
  public static void main(String[] args) {
    PizzaStore chicagoStore = new ChicagoStylePizzaStore();
    NYStylePizzaStore nyStore = new NYStylePizzaStore();

    Pizza pizza = chicagoStore.orderPizza("clam");
    System.out.println("Ethan ordered a " + pizza.getName() + "\n");

    pizza = nyStore.orderPizza("cheese");
    System.out.println("Joel ordered a " + pizza.getName() + "\n");
  }
}
