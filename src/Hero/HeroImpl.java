package Hero;

import Weapon.WeaponImpl;

public class HeroImpl implements Hero {

    private int health;
    public final String HERONAME;
    private final WeaponImpl weapon;
    public HeroImpl(WeaponImpl weapon, int health, String name) {
        this.weapon = weapon;
        this.health = health;
        this.HERONAME = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int attack() {
        return weapon.weaponDamage();
    }

    public void getDamage(int damage) {
        health -= damage;
    }

    public boolean diedOrNot() {
        return health <= 0;
    }

    @Override
    public String toString() {
        return "Герой: " + HERONAME + ", здоровье: " + health + ", оружие: " + weapon.weaponName + ", урон:" + weapon.weaponDamage();
    }
}
