import java.util.Scanner;

public class DeleteNumbers {
    public static void main(String[] args) {
        System.out.println("Введите количество элементов в последовательности чисел");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 0 || n > 1000)
        {
            System.out.println("Введено некорректное значение");
        }
        else{
            int size = 1001;
            boolean[] mas = new boolean[size];
            int index;

            System.out.printf("Введите последовательность из %d элементов\n", n);
            for (int i = 0; i < n; i++) {
                index = scanner.nextInt();
                mas[index] = true;
            }

            for (int i = 0; i < size; i++) {
                if (mas[i] == true)
                    System.out.print(i+" ");
            }
        }
    }
}
