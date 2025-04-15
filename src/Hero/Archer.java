package Hero;

import Weapon.Bow;

public class Archer extends HeroImpl {
    public Archer(int health) {
        super(new Bow(), health, "Лучник");
    }

}
