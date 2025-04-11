public class Bank {
    private int maxSumma;
    private int curCountSchet = 0;
    private final int MAXCOUNTSCHET = 10;
    private Schet[] bankAcconts = new Schet[MAXCOUNTSCHET];
    Bank(int maxSumma){
        this.maxSumma = maxSumma;
    }

    private boolean limit(int addMoney){
        int summa = 0;
        for (int i = 0; i < curCountSchet; i++)
            summa += bankAcconts[i].getSumma();
        if(summa + addMoney > maxSumma)
            return false;
        return true;
    }

    private void limitError(){
        System.out.println("Операция отклонена. Лимит суммарных денежных средств по всем счетам для банка превышен!");
    }

    public void newSchet(String name, int money){
        if(limit(money)){
            bankAcconts[curCountSchet] = new Schet(name, money);
            curCountSchet++;
        }
        else
            limitError();

    }
    private int findSchet(String name){
        int nomer = -1;
        for(int i = 0; i < curCountSchet; i++){
            if(bankAcconts[i].getName().equals(name))
            {
                nomer = i;
                break;
            }
        }
        return nomer;
    }

    public void addMoney(String name, int money){
        if(limit(money)) {
            int nomer = findSchet(name);
            if (nomer >= 0)
                bankAcconts[nomer].addSumma(money);
            else
                System.out.println(name + " не является клиентом банка");
        }
        else
            limitError();
    }


    public void getInfotmation(){
        for(int i = 0; i < curCountSchet; i++){
            System.out.print("Порядковый номер счета " + i + " -> ");
            bankAcconts[i].printSchet();
        }
    }

    private void getInfotmation(int nomer){
            bankAcconts[nomer].printSchet();
    }

    public void subMoney(String name, int money){
        int nomer = findSchet(name);
        if(nomer >= 0)
            bankAcconts[nomer].subSumma(money);
        else
            System.out.println(name + " не является клиентом банка");
    }

    public void perevodMoney(String subName, String addName, int summa){
        boolean flag = true;
        int subNomer = findSchet(subName);
        if(subNomer < 0){
            System.out.println("Денежный перевод невозможен, т. к. имя отправителя указано неверно!");
            flag = false;
        }
        if(bankAcconts[subNomer].getSumma() < summa){
            System.out.println("Денежный перевод невозможен, т. к. у отправителя недостаточно средств!");
            flag = false;
        }

        int addNomer = findSchet(addName);
        if(addNomer < 0){
            System.out.println("Денежный перевод невозможен, т. к. имя получателя указано неверно!");
            flag = false;
        }

        if(flag){
            bankAcconts[subNomer].subSumma(summa);
            bankAcconts[addNomer].addSumma(summa);
        }
    }

}
