package Weapon;

public class WeaponImpl implements Weapon{
    private final int damage;
    private final String weaponName;

    public WeaponImpl(int damage, String weaponName){
        this.damage = damage;
        this.weaponName = weaponName;
    }

    @Override
    public int weaponDamage() {
        return damage;
    }

    @Override
    public String getName() {
        return weaponName;
    }

    @Override
    public String toString() {
        return "Оружие: " + weaponName + ", урон: " + damage;
    }
}
