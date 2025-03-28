package Viselitsa;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        while(!Player.viselitsa())
        {
            System.out.println("До выигрыша первого игрока осталось " + (Player.numMaxRounds - Player.numLooseRound) + " раундов");
            player.printUgadal();
            Player.playRound();
            if(Player.ugadalSlovo()) break;
        }
        if (!Player.viselitsa())
            System.out.println("Выиграл второй игрок");
        else
            System.out.println("Выиграл первый игрок");

    }

    static class Player{
        static String ugadika;//загадавыаемое слово
        static String ugadal;
        static int numLooseRound = 0;//число неудачных попыток
        static int numMaxRounds = "Виселица".length();// максимальное количество раундов

        Player()
        {
            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while(flag)
            {
                flag = false;
                System.out.println("Первый игрок, загадайте слово");
                ugadika = scanner.next().toLowerCase();
                char[] chars = ugadika.toCharArray();
                for (char c : chars)
                    if (!Character.isLetter(c))
                    {
                        System.out.println("Введенное слово состоит не только из букв");
                        flag = true;
                        break;
                    }
            }
            StringBuilder str = new StringBuilder(ugadika);
            for (int i = 0; i < ugadika.length(); i++)
                str.setCharAt(i,'*');
            ugadal = str.toString();
        }

       static void printUgadal()
        {
            System.out.println("Все, что знает второй игрок о загаднном слове");
            System.out.println(ugadal);
        }

        static void playRound()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Второй игрок, введите букву");
            char letter = scanner.next().charAt(0);
            if(!(Character.isLetter(letter)))
            {
                System.out.println("Введенный символ не является буквой!");
                return;
            }
            if(ugadika.indexOf(letter) == -1)
            {
                numLooseRound++;
                System.out.println("Второй игрок не угадал, такой буквы в слове нет");
                return;
            }
            int indexStart = 0;
            while(true)
            {
                indexStart = ugadika.indexOf(letter,indexStart);
                if(indexStart == -1) break;
                StringBuilder str = new StringBuilder(ugadal);
                str.setCharAt(indexStart,letter);
                ugadal = str.toString();
                indexStart++;
            }
            System.out.println("Второй игрок угадал, такая буква в слове есть");
        }

        static boolean ugadalSlovo()
        {
            if (ugadal.indexOf('*') == -1)
                return true;
            return false;
        }

        static boolean viselitsa()
        {
           if (numLooseRound < numMaxRounds)
               return false;

           return true;
        }
    }
}
