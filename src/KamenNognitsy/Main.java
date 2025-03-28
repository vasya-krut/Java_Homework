package KamenNognitsy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Игрок 1");
        Player player1 = new Player();
        System.out.println("Игрок 2");
        Player player2 = new Player();
        Player.printNumRounds();
        while(Player.numCurRound < Player.numRounds)
        {
            player1.cardChoose();
            player2.cardChoose();
            Player.playRound(player1.card, player2.card);
            if (Player.curRoundWinner == 1 | Player.curRoundWinner == 2)
            {
                if (Player.curRoundWinner == 1)
                    player1.winner();
                else
                    player2.winner();
                Player.numCurRound++;
            }
            else
                System.out.println("Ничья! Раунд переигрывается.");
            player1.getNumWinner();
            player2.getNumWinner();
        }
    }

    static class Player{
        String name = "Player";
        int card = 0;// код одной выбранной карты из четырех
        int numWinner = 0; //количество побед игрока
        static int numRounds = 2; //количество раундов в игре
        static int numCurRound = 0; // номер текущего руанда
        static int curRoundWinner = 0;//0, если ничья: 1, если победил 1 игрок; 2, если победил 2 игрок

        Player()
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите свое имя ...");
            name = scanner.next();
        }

        public void cardChoose()
        {
            Scanner scanner = new Scanner(System.in);
            while(true)
            {
                System.out.println("Игрок " + name +", выберите одну из карт: 0 - камень, 1 - ножницы, 2 - бумага, 3 - колодец");
                card = scanner.nextInt();
                if (card<0 | card>3)
                    System.out.println("Введена неверная цифра! Введите еще раз");
                else break;
            }
        }

        static void printNumRounds()
        {
            System.out.println("Игра ведется до " + numRounds + " побед");
        }

        public void getNumWinner()
        {
            System.out.println("Игрок " + name + " одержал " + numWinner + " побед");
        }

        static void playRound(int player1Card, int player2Card)
        {
            if(player1Card == player2Card)
            {
                curRoundWinner = 0;
                return;
            }
            switch (player1Card)
            {
                case 0:{
                    if (player2Card == 1)
                        curRoundWinner = 1;
                    else
                        curRoundWinner = 2;
                    break;
                }
                case 1:{
                    if (player2Card == 2)
                        curRoundWinner = 1;
                    else
                        curRoundWinner = 2;
                    break;
                }
                case 2:{
                    if (player2Card == 0 | player2Card == 3)
                        curRoundWinner = 1;
                    else
                        curRoundWinner = 2;
                    break;
                }
                case 3:{
                    if (player2Card == 0 | player2Card == 1)
                        curRoundWinner = 1;
                    else
                        curRoundWinner = 2;
                    break;
                }
            }
        }

        public void winner()
        {
            numWinner++;
            System.out.println("Игрок " + name + " выиграл");
        }
    }
}
