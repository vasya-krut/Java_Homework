import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Fibonachi {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов в последовтаельности чисел Фибоначчи ...");
        int n = scanner.nextInt();

        if(n <= 0) System.out.println("Введено некрректное число");
        else {
            int old = 0, cur = 1, next;
            for (int kol = 0; kol < n; kol++)
            {
                if(kol == 0)
                {
                    System.out.print("0, ");
                    continue;
                }
                if(kol == 1)
                {
                    System.out.print("1, ");
                    continue;
                }
                next = cur + old;
                System.out.printf("%d, ", next);
                old = cur;
                cur = next;
            }

        }






    }
}