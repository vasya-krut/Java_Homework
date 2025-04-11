//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        bank.newSchet("Андрей", 100);
        bank.newSchet("Виктория", 200);
        bank.newSchet("Василий", 200);
        bank.newSchet("Виктор", 100);
        bank.newSchet("Мария", 200);
        bank.newSchet("Сергей", 300);
        bank.getInfotmation();
        bank.addMoney("Сергей", 100);
        bank.subMoney("Сергей", 100);
        bank.subMoney("Виктор", 100);
        bank.addMoney("Мария", 100);
        bank.perevodMoney("Мария", "Виктор", 200);
        bank.getInfotmation();
    }
}