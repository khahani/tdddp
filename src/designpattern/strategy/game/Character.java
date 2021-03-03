package designpattern.strategy.game;

public abstract class Character {
  protected WeaponBehavior weaponBehavior;

  public void setWeaponBehavior(WeaponBehavior wb) {
    this.weaponBehavior = wb;
  }

  public abstract void fight();
}
