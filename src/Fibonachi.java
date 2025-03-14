import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Fibonachi {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов в последовтаельности чисел Фибоначчи ...");
        int N = scanner.nextInt();

        if(N<=0) System.out.println("Введено некрректное число");
        else {
            switch (N) {
                case (1): {
                    System.out.println("0");
                    break;
                }
                case (2): {
                    System.out.println("0, 1");
                    break;
                }
                default:
                    int a_old = 0, a_cur = 1, a_next;
                    System.out.print("0, 1, ");
                    int kol = 2;
                    do {
                        a_next = a_cur + a_old;
                        System.out.printf("%d, ", a_next);
                        kol++;
                        a_old = a_cur;
                        a_cur = a_next;
                    } while (kol < N);
            }
        }






    }
}