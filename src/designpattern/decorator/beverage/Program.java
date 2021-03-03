package designpattern.decorator.beverage;

import designpattern.decorator.beverage.condiment.Mocha;
import designpattern.decorator.beverage.condiment.Soy;
import designpattern.decorator.beverage.condiment.Whip;

public class Program {
  public static void main(String[] args) {
    Beverage beverage = new Espresso();
    beverage.setSize(Beverage.TALL);
    System.out.println(beverage.getDescription() +
            " $" + beverage.cost());

    Beverage beverage1 = new DarkRoast();
//    beverage1.setSize(Beverage.TALL);
    beverage1 = new Mocha(beverage1);
    beverage1 = new Mocha(beverage1);
    beverage1 = new Whip(beverage1);

    System.out.println(beverage1.getDescription() +
            " $" + beverage1.cost());

    Beverage beverage2 = new HouseBlend();
    beverage2 = new Soy(beverage2);
    beverage2 = new Mocha(beverage2);
    beverage2 = new Whip(beverage2);

    System.out.println(beverage2.getDescription() +
            " $" + beverage2.cost());
  }
}
