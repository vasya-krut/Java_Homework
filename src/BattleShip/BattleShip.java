package BattleShip;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Scanner;

public class BattleShip {




    public static void main(String[] args) {

        BattleField playerSeekComputerField = new BattleField();
        BattleField playerField = new BattleField();
        playerField.fieldFill();
        BattleField computerField = new BattleField();
        computerField.fieldFill();

        System.out.println("Расположение ваших кораблей");
        playerField.printField();

        Scanner scanner = new Scanner(System.in);
        int x,y;
        int resultatVystrela;

        while(computerField.proboina > 0 && playerField.proboina > 0)//пока не закончатся корабли у одного из противников
        {
            System.out.println("Все что известно о кораблях противника");
            playerSeekComputerField.printField();
            System.out.println("Введите координаты удара x y");
            x = scanner.nextInt();
            y = scanner.nextInt();
            if ( x < 0 || x >= computerField.size || y < 0 || y >= computerField.size)
            {
                System.out.println("Введены неправильные координты");
                continue;
            }

            resultatVystrela = computerField.vystrel(x, y);

            if(resultatVystrela == -1)
            {
                System.out.println("Вы уже стреляли по этим координатам");
            }

            if (resultatVystrela == 2)
            {
                System.out.println("Мимо!");
                playerSeekComputerField.field[x][y] = 2;
                System.out.println("Ход компьютера ...");
                computerStep(playerField,computerField);
                System.out.println("Все что осталось от вашей эскадры после обстрела");
                playerField.printField();
            }

            if(resultatVystrela == 3)
            {
                System.out.println("Попал!");
                playerSeekComputerField.field[x][y] = 3;
            }


        }

    }

    static void computerStep(BattleField playerField, BattleField computerField)
    {
        Random rand = new Random();
        int x, y;
        int resultatVystrela;

        while(true)
        {
            x = rand.nextInt(playerField.size);
            y = rand.nextInt(playerField.size);
            resultatVystrela = computerField.vystrel(x, y);
            if(resultatVystrela == 2)// компьютер промахнулся
                break;
            if(playerField.proboina == 0)
            {
                System.out.println("Компьютер победил!");
                break;
            }
        }
    }
}
