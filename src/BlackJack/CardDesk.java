package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDesk {
    int kolodaSize=36;
    Card [] koloda = new Card [kolodaSize]; // колода карт
    int [] porjadokCard = new int [kolodaSize]; // перетасованная колода,
    // индекс массива соотвествует порядковому номеру карты в перетасованной колоде,
    // значение элемента массива -  коду карты в колоде (koloda)
    int topKoloda;//указать на верхнюю карту

    public CardDesk(){
        String [] nominalDefault = {"6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};
        String [] mastDefault = {"Черви", "Буба", "Крести", "Пики"};
        int iter=0;
        for (String nominalCreate : nominalDefault){
            for (String mastCreate : mastDefault){
                koloda[iter]=new Card (nominalCreate, mastCreate);
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
            porjadokCard[i] = numbers.removeFirst();
        }
        topKoloda=0;
    }



    public void cardShow(int index)
    {
        System.out.println(koloda[porjadokCard[index]].nominal+" "+koloda[porjadokCard[index]].mast);
    }

    public int getCardWeight1(int index)
    {
        return koloda[porjadokCard[index]].weight1;
    }

    public int getCardWeight2(int index)
    {
        return koloda[porjadokCard[index]].weight2;
    }

    public boolean cardIsTuz(int index)
    {
        if(koloda[porjadokCard[index]].nominal == "Туз") return true;
        return  false;
    }

    public int getCard()//взять карту с вершины колоды
    {
        topKoloda++;
        return porjadokCard[topKoloda-1];
    }

}
