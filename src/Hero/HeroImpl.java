package Hero;

import Weapon.WeaponImpl;

import java.util.Random;

public class HeroImpl implements Hero {

    private int health;
    private final String heroName;
    private final WeaponImpl weapon; //WeaponImpl - это класс, а Weapon интерфейс
    public HeroImpl(WeaponImpl weapon, int health, String name) {
        this.weapon = weapon;
        this.health = health;
        this.heroName = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return heroName;
    }

    @Override
    public int attack(HeroImpl hero) {
        Random rand = new Random();
        int uron = rand.nextInt(weapon.weaponDamage() + 1);
        hero.health -= uron;
        return uron;
    }




    public boolean isDied() {
        return health <= 0;
    }

    @Override
    public String toString() {
        return "Герой: " + heroName + ", здоровье: " + health + ", оружие: " + weapon.getName() + ", урон:" + weapon.weaponDamage();
    }
}
