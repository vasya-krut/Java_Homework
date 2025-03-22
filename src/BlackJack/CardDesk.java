package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDesk {
    int kolodaSize = 36;
    Card [] koloda = new Card [kolodaSize]; // колода карт

    int topKoloda;//указать на верхнюю карту

    public CardDesk(){
        String [] nominalDefault = {"6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};
        String [] mastDefault = {"Черви", "Буба", "Крести", "Пики"};
        int iter = 0;
        for (String nominalCreate : nominalDefault){
            for (String mastCreate : mastDefault){
                koloda[iter] = new Card (nominalCreate, mastCreate);
                iter++;
            }
        }
    }

    public void peretosovat(){ // перетасовать колоду
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < kolodaSize; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < kolodaSize; i++){
            koloda[i].cardNumber = numbers.removeFirst();
        }
        topKoloda=0;
    }

    public int findCard(int index)//найти по порядковому номеру карты в перетасованной колоде
    {
        for (int i = 0; i < kolodaSize; i++)
        {
            if(koloda[i].cardNumber == index)
                return i;
        }
        return 0;// никогда не выполнится, т. к. карты с нужным порядковым номером всегда есть в колоде
    }

    public void cardShow(int index)
    {
        int nomer = findCard(index);
        System.out.println(koloda[nomer].nominal + " " + koloda[nomer].mast);
    }

    public int getCardWeight1(int index)
    {
        int nomer = findCard(index);
        return koloda[nomer].weight1;
    }

    public int getCardWeight2(int index)
    {
        int nomer = findCard(index);
        return koloda[nomer].weight2;
    }

    public boolean cardIsTuz(int index)
    {
        int nomer = findCard(index);
        if(koloda[nomer].nominal == "Туз") return true;
        return  false;
    }

    public int getCard()//взять карту с вершины колоды
    {
        int temp = topKoloda;
        topKoloda++;
        return temp;
    }

}
