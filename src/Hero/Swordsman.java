package Hero;

import Weapon.Sword;

public class Swordsman extends HeroImpl {
    public Swordsman(int health) {
        super(new Sword(), health, "Мечник");
    }
}
