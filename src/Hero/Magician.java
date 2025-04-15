package Hero;

import Weapon.Staff;

public class Magician extends HeroImpl {

    public Magician(int health) {
        super(new Staff(), health, "Маг");
    }
}