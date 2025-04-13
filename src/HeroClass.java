public class HeroClass extends WeaponClass implements Hero{

    int health;
    final String HERONAME;
    HeroClass(WeaponClass weapon, int health, String name) {
        super(weapon.damage, weapon.weaponName);
        this.health = health;
        this.HERONAME = name;
    }

    @Override
    public String toString() {
        return "Герой: " + HERONAME + ", здоровье: " + health + ", оружие: " + weaponName + ", урон:" + damage;
    }

    public void getDamage(int damage) {
        health -= damage;
    }

    public boolean diedOrNot() {
        if(health <= 0) return true;
        return false;
    }
}
