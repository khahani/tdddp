package designpattern.strategy.game;

import designpattern.strategy.game.weapons.BowAndArrowBehavior;
import designpattern.strategy.game.weapons.KnifeBehavior;

public class Game {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Character c = null;
      if (i < 5)
        c = new King();
      else
        c = new Queen("Elham", 5);

      c.setWeaponBehavior(new KnifeBehavior());
      c.fight();
      c.setWeaponBehavior(new BowAndArrowBehavior(3));
      c.fight();

    }

  }
}
