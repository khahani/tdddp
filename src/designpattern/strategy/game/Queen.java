package designpattern.strategy.game;

public class Queen extends Character {

  private final String name;
  private final int power;

  public Queen(String name, int power) {
    this.name = name;
    this.power = power;
  }

  @Override
  public void fight() {
    System.out.println(name + " fighting");
    for (int i = 0; i < power; i++) {
      weaponBehavior.useWeapon();
    }
  }
}
