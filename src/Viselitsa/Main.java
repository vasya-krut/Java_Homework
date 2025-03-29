package Viselitsa;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Первый игрок, введите свое имя");
        String name1 = scanner.next();
        Player player1 = new Player(name1);
        System.out.println("Второй игрок, введите свое имя");
        String name2 = scanner.next();
        Player player2 = new Player(name2);
        System.out.println("Введите количество побед, до которого идет игра");
        int numMaxWins = scanner.nextInt();
        int gameNum = 1; // номер игры

        while(player1.numWins < numMaxWins & player2.numWins < numMaxWins) {
            if(gameNum % 2 == 1){//каждую игру игроки загадывающий и отгадывающий слово меняются местами
                name1 = player1.name;
                name2 = player2.name;
            }
            else {
                name2 = player1.name;
                name1 = player2.name;
            }

            Game game = new Game(name1, name2);

            if (game.playGame()){
                System.out.println(name2 + " выиграл");
                if(gameNum % 2 == 1)
                    player2.numWins++;
                else
                    player1.numWins++;
            }
            else {
                System.out.println(name1 + " выиграл");
                if(gameNum % 2 == 1)
                    player1.numWins++;
                else
                    player2.numWins++;
            }
            System.out.println("Счет после " + gameNum + " раунда стал: " + player1.name + " " + player1.numWins + ", " + player2.name + " " + player2.numWins);
            gameNum++;
        }
        if(player1.numWins > player2.numWins)
            System.out.println("Серию игр выиграл " + player1.name);
        else
            System.out.println("Серию игр выиграл " + player2.name);
    }

    static class Game{
        String player1Name;
        String player2Name;
        private String ugadika;//загадавыаемое слово
        private String ugadal;
        private int numLooseRound = 0;//число неудачных попыток
        final int numMaxRounds = "Виселица".length();// максимальное количество раундов


        Game(String name1, String name2)
        {
            player1Name = name1;//всегда загадывает слово
            player2Name = name2;// всегда отгадывает слово
            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while(flag)
            {
                flag = false;
                System.out.println(player1Name + ", загадайте слово");
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

        public boolean playGame(){//возвращает true, если победил второй игрок (отгадывающий слово)

            while (!viselitsa()) {
                System.out.println("До выигрыша игрока " + player1Name + " осталось " + (numMaxRounds - numLooseRound) + " раундов");
                printUgadal();
                playRound();
                if (ugadalSlovo()) break;
            }
            return ugadalSlovo();
        }

       private void printUgadal()
        {
            System.out.println("Все, что знает " + player2Name + " о загаднном слове");
            System.out.println(ugadal);
        }

        private void playRound()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println( player2Name + ", введите букву");
            char letter = scanner.next().charAt(0);
            if(!(Character.isLetter(letter)))
            {
                System.out.println("Введенный символ не является буквой!");
                return;
            }
            if(ugadika.indexOf(letter) == -1)
            {
                numLooseRound++;
                System.out.println(player2Name + " не угадал, такой буквы в слове нет");
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
            System.out.println(player2Name + " угадал, такая буква в слове есть");
        }

        private boolean ugadalSlovo()
        {
            if (ugadal.indexOf('*') == -1)
                return true;
            return false;
        }

        private boolean viselitsa()
        {
           if (numLooseRound < numMaxRounds)
               return false;
           return true;
        }
    }

    static class Player{
        String name;
        int numWins = 0;
        Player(String name){
            this.name = name;
        }

        public void playerWin(){
            numWins++;
        }

    }
}
