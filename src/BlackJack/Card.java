package BlackJack;

public class Card {
    String nominal; //6 7 8 9 10 Валет Дама Король Туз
    String mast;// Черви Буба Крести Пика
    int weight1; // 6 7 8 9 10 11
    int weight2; // 6 7 8 9 10 1 (Туз имеет два веса)

    public Card (String nominal,  String mast){
        this.nominal=nominal;
        this.mast=mast;
        switch (nominal){
            case("6"):{
                this.weight1=6;
                this.weight2=6;
                break;
            }

            case("7"):{
                this.weight1=7;
                this.weight2=7;
                break;
            }

            case("8"):{
                this.weight1=8;
                this.weight2=8;
                break;
            }

            case("9"):{
                this.weight1=9;
                this.weight2=9;
                break;
            }

            case("10"):{
                this.weight1=10;
                this.weight2=10;
                break;
            }

            case("Туз"):{
                this.weight1=11;
                this.weight2=1;
                break;
            }

            default:{
                this.weight1=10;
                this.weight2=10;
            }
        }
    }

    public void printCard(){
        System.out.println(nominal+""+mast);
    }
}
