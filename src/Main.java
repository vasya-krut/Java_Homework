import Hero.Archer;
import Hero.HeroImpl;
import Hero.Magician;
import Hero.Swordsman;

import java.util.Random;
import java.util.Scanner;


public class Main {
    static private Random rand = new Random();
    static private HeroImpl[] heroArray = new HeroImpl[3];
    static private int vyborComp;
    static private int vyborPlayer;

    public static void main(String[] args) {
        createHeroArray();
        vyborHeroes();
        draka();
  }

    private static void createHeroArray(){
        heroArray[0] = new Swordsman(rand.nextInt(101) + 100);
        heroArray[1] = new Archer(rand.nextInt(61) + 100);
        heroArray[2] = new Magician(rand.nextInt(41) + 100);
    }

    private static void vyborHeroes(){
        System.out.println("Для выбора доступно 3 героя:");
        for(int i = 0; i < 3; i++)
            System.out.println(i + "-" + heroArray[i]);
        System.out.println("Какого героя вы выберите?");
        Scanner scan = new Scanner(System.in);
        vyborPlayer = scan.nextInt();

        vyborComp = vyborPlayer;
        while(vyborComp == vyborPlayer)
            vyborComp = rand.nextInt(3);
    }

    private static void draka(){
        while (true) {
            System.out.println(heroArray[vyborPlayer]);
            System.out.println(heroArray[vyborComp]);

            int playerAttack = rand.nextInt(heroArray[vyborPlayer].attack()+1);
            heroArray[vyborComp].getDamage(playerAttack);
            System.out.println("Игрок нанес " + playerAttack + " урона");

            if(heroArray[vyborComp].diedOrNot()) {
                System.out.println("Игрок победил!");
                break;
            }

            int compAttack = rand.nextInt(heroArray[vyborComp].attack()+1);
            heroArray[vyborPlayer].getDamage(compAttack);
            System.out.println("Компьютер нанес " + compAttack + " урона");

            if(heroArray[vyborPlayer].diedOrNot()) {
                System.out.println("Компьтер победил!");
                break;
            }
        }
    }


}