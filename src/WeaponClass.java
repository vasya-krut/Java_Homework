abstract class WeaponClass implements Weapon{
    final int damage;
    final String weaponName;

    WeaponClass(int damage, String weaponName){
        this.damage = damage;
        this.weaponName = weaponName;
    }

    @Override
    public int atack() {
        return damage;
    }

    @Override
    public String toString() {
        return "Оружие: " + weaponName + ", урон: " + damage;
    }
}
