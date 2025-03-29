package KamenNognitsy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Игрок 1, введите свое имя");
        name = scanner.next();
        Player player1 = new Player(name);
        System.out.println("Игрок 2, введите свое имя");
        name = scanner.next();
        Player player2 = new Player(name);


        int numRounds = 2; //количество раундов в игре
        int numCurRound = 0; // номер текущего руанда
        int curRoundWinner = 0;//0, если ничья: 1, если победил 1 игрок; 2, если победил 2 игрок

        System.out.println("Игра ведется до " + numRounds + " побед");
        while(numCurRound < numRounds){
            player1.cardChoose();
            player2.cardChoose();
            curRoundWinner = Player.playRound(player1.card, player2.card);
            if (curRoundWinner == 1 | curRoundWinner == 2)
            {
                if (curRoundWinner == 1)
                    player1.winner();
                else
                    player2.winner();
                numCurRound++;
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


        Player(String name)
        {
            this.name = name;
        }

        public void cardChoose()
        {
            Scanner scanner = new Scanner(System.in);
            while(true)
            {
                System.out.println("Игрок " + name +", выберите одну из карт: 0 - камень, 1 - ножницы, 2 - бумага, 3 - колодец");
                card = scanner.nextInt();
                if (card < 0 | card > 3) {
                    System.out.println("Введена неверная цифра! Введите еще раз");
                } else break;
            }
        }



        public void getNumWinner()
        {
            System.out.println("Игрок " + name + " одержал " + numWinner + " побед");
        }

        static int playRound(int player1Card, int player2Card)
        {
            if(player1Card == player2Card)
            {
                return 0;
            }
            switch (player1Card)
            {
                case 0:{
                    if (player2Card == 1)
                        return  1;
                    else
                        return  2;
                }
                case 1:{
                    if (player2Card == 2)
                        return  1;
                    else
                        return  2;
                }
                case 2:{
                    if (player2Card == 0 | player2Card == 3)
                        return  1;
                    else
                        return  2;
                }
                case 3:{
                    if (player2Card == 0 | player2Card == 1)
                        return  1;
                    else
                        return  2;
                }
            }
            return 0;//никогда не выполнится
        }

        public void winner()
        {
            numWinner++;
            System.out.println("Игрок " + name + " выиграл");
        }
    }
}
