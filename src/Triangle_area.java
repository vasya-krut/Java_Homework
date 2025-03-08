import java.util.Scanner;

public class Triangle_area {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите координаты (x, y) первой вершины треугольника");
        System.out.print("x=");
        double A_x=scan.nextDouble();
        System.out.print("y=");
        double A_y=scan.nextDouble();

        System.out.println("Введите координаты (x, y) второй вершины треугольника");
        System.out.print("x=");
        double B_x=scan.nextDouble();
        System.out.print("y=");
        double B_y=scan.nextDouble();

        System.out.println("Введите координаты (x, y) третьей вершины треугольника");
        System.out.print("x=");
        double C_x=scan.nextDouble();
        System.out.print("y=");
        double C_y=scan.nextDouble();

        double AB=Math.sqrt(Math.pow((A_x-B_x),2)+Math.pow((A_y-B_y),2));//длина стороны AB треугольника ABC
        double AC=Math.sqrt(Math.pow((A_x-C_x),2)+Math.pow((A_y-C_y),2));//длина стороны AС треугольника ABC
        double BC=Math.sqrt(Math.pow((C_x-B_x),2)+Math.pow((C_y-B_y),2));//длина стороны BС треугольника ABC
        double p=(AB+AC+BC)/2;// полупериметр треугольника ABC
        double S=Math.sqrt(p*(p-AB)*(p-BC)*(p-AC));//площадь треугольника ABC по формуле Герона

        System.out.printf("Площадь треугольника равна %f",S);


    }
}
