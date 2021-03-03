package designpattern.factory.pizza;

public class ChicagoClamPizza extends Pizza {
  public ChicagoClamPizza() {
    name = "Chicago style deep dish cheese pizza";
    dough = "Extra thick crust dough";
    sauce = "Plum Tomato Sauce";

    toppings.add("Shredded mozzarella cheese");
  }

  void cut() {
    System.out.println("Cutting the pizza into square slices");
  }
}
