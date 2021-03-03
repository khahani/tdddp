package designpattern.adapter.duck;

public class Program {
  public static void main(String[] args) {

    MallardDuck duck = new MallardDuck();

    WildTurkey turkey = new WildTurkey();
    Duck turkeyAdapter = new TurkeyAdapter(turkey);

    System.out.println("The Turkey says...");
    turkey.gobble();
    turkey.fly();

    System.out.println("The Duck says...");
    testDuck(duck);

    System.out.println("The TurkeyAdapter says...");
    testDuck(turkeyAdapter);
  }

  private static void testDuck(Duck duck) {
    duck.quake();
    duck.fly();
  }
}
