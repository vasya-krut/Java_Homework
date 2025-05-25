package View;

import java.util.List;
import java.util.Scanner;

public class MyView {
    private Scanner scanner;

    public MyView(){
        System.out.println("Вас приветсвует программа шифррования/дешифрования");
        scanner = new Scanner(System.in);
    }

    public int getParametr(List<Integer> list) {
        int parametr;
        while(true){
            System.out.printf("Укажите размер блока шифрования: " + list + '\n');
            parametr = scanner.nextInt();
            if (list.contains(parametr)) break;
        }
        return parametr;
    }

    public int menu(){
            System.out.println("Если хотите выйти из программы, введите -1");
            System.out.println("Если хотите зашифровать файл, введите 0");
            System.out.println("Если хотите дешифровать файл, введите 1");
            return  scanner.nextInt();
    }

    public String shifr(){
        System.out.println("Укажите путь к файлу для шифрования");
        return scanner.next();
    }

    public String deshifr(){
        System.out.println("Укажите путь к файлу для дешифрования");
        return scanner.next();
    }

    public void shifrUspeh(String path){
        System.out.println("Файл " + path + " успешно зашифрован");
    }

    public void deshifrUspeh(String path){
        System.out.println("Файл " + path + " успешно дешифрован");
    }

}
