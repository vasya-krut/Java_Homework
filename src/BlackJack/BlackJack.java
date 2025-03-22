package BlackJack;

import java.util.Scanner;

public class BlackJack {
    public static int[] dealerCard = new int[2];// у дилера всегда две карты
    public static int[] playerCard=new int[34];// больше чем 34 карты у игрока не может быть
    public static int playerCardKol;
    public static CardDesk cardDesk = new CardDesk();


    public static void main(String[] args) {
      cardDesk.peretosovat();

      dealerCard[0] = cardDesk.getCard();
      dealerCard[1] = cardDesk.getCard();
      playerCard[0] = cardDesk.getCard();
      playerCard[1] = cardDesk.getCard();
      playerCardKol = 2;
      playerCadShow(playerCardKol);

      Scanner scanner = new Scanner(System.in);

      while(true)
      {
          System.out.println("Хотите взять еще карту? Y or N?");
          String otvet = scanner.nextLine();
          System.out.println(otvet);
          if(otvet.equalsIgnoreCase("N")){
              roundEnd();
              break;
          }
          if(otvet.equalsIgnoreCase( "Y"))
          {
              playerCard[playerCardKol] = cardDesk.getCard();
              playerCardKol++;
              playerCadShow(playerCardKol);
          }
          else
              System.out.println("Ваш ответ не понятен.");

          if(playerCardKol == 34)//больше карт в колоде не осталось
              break;
      }
    }

    public static void roundEnd()
    {
        System.out.println("Карты дилера ...");
        int dealerPoints = 0;
        for(int i = 0; i < 2; i++)
        {
            cardDesk.cardShow(dealerCard[i]);
            dealerPoints += cardDesk.getCardWeight1(dealerCard[i]);
        }
        System.out.println("У дилера "+dealerPoints+" очков.");

        playerCadShow(playerCardKol);
        int playerPoints1 = 0; // очки игрока с первым весом
        int playerPoints2 = 0; // очки игрока со вторым весом
        for(int i = 0; i < playerCardKol; i++)
        {
            playerPoints1 += cardDesk.getCardWeight1(playerCard[i]);
            if(cardDesk.cardIsTuz(playerCard[i]))
                playerPoints2 += cardDesk.getCardWeight2(playerCard[i]);
            else
                playerPoints2 += cardDesk.getCardWeight1(playerCard[i]);
        }
        int playerPoints;
        if (playerPoints1 <= 21) // у туза два веса
            playerPoints = playerPoints1;
        else
            playerPoints = playerPoints2;
        System.out.println("У игрока "+playerPoints+" очков.");

        winner(dealerPoints,playerPoints);

    }


    public static void winner(int dealerPoints, int playerPoints) {
        if (dealerPoints == playerPoints)
        {
            System.out.println("Ничья!");
            return;
        }
        if (dealerPoints < 21 & playerPoints > 21){
            System.out.println("Дилер выиграл!");
            return;
        }

        if (dealerPoints > 21 & playerPoints < 21){
            System.out.println("Игрок выиграл!");
            return;
        }

        if (Math.abs(21 - dealerPoints) > Math.abs(21 - playerPoints))
            System.out.println("Игрок выиграл!");
        else
            System.out.println("Дилер выиграл!");

    }

    public static void playerCadShow(int numPlayerCard){
        System.out.println("Карты игрока ...");
        for( int i = 0; i < numPlayerCard; i++)
            cardDesk.cardShow(playerCard[i]);
    }
}