public class Schet {
    private String name = "noName";//уникальный идентификатор
    private int summa = 0;

    Schet(String name, int summa){
        this.name = name;
        this.summa = summa;
    }

    protected String getName() {
        return name;
    }

    protected int getSumma() {
        return summa;
    }

    protected void addSumma(int money)
    {
        summa += money;
    }

    protected void subSumma(int money)
    {
        summa -= money;
    }

    protected void printSchet(){
        System.out.println("Name: " + name + ", summa: " + summa);
    }
}
