package designpattern.strategy.game.weapons;

import designpattern.strategy.game.WeaponBehavior;

public class BowAndArrowBehavior implements WeaponBehavior {

  private final int level;

  public BowAndArrowBehavior(int level) {
    this.level = level;
  }

  @Override
  public void useWeapon() {
    if (level > 3)
      System.out.println("Super Bow");
    else
      System.out.println("Normal Bow");
  }
}
