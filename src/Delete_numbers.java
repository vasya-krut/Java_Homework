import java.util.Scanner;

public class Delete_numbers {
    public static void main(String[] args) {
        System.out.println("Введите количество элементов в последовательности чисел");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N <= 0 || N>1000)
        {
            System.out.println("Введено некорректное значение");
        }
        else{
            int size=1001;
            boolean[] mas = new boolean[size];
            int index;

            System.out.printf("Введите последовательность из %d элементов\n", N);
            for (int i = 0; i < N; i++) {
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
