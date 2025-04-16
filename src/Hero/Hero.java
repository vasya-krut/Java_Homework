package Hero;

public interface Hero {

    boolean isDied();

    int attack(HeroImpl hero);

    int getHealth();

    String getName();
}
