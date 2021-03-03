package designpattern.strategy.game.weapons;

import designpattern.strategy.game.WeaponBehavior;

public class KnifeBehavior implements WeaponBehavior {
  @Override
  public void useWeapon() {
    System.out.println("Ghach Ghach");
  }
}
