package designpattern.strategy.game;

public class King extends Character {

  @Override
  public void fight() {
    weaponBehavior.useWeapon();
    weaponBehavior.useWeapon();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    weaponBehavior.useWeapon();
    weaponBehavior.useWeapon();
  }
}
