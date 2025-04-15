package Weapon;

public class WeaponImpl implements Weapon{
    private final int damage;
    public final String weaponName;

    public WeaponImpl(int damage, String weaponName){
        this.damage = damage;
        this.weaponName = weaponName;
    }

    @Override
    public int weaponDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Оружие: " + weaponName + ", урон: " + damage;
    }
}
