package ru.academitschool.oop.shelestov.demo;
import ru.academitschool.oop.shelestov.work.*;


public class Main {
    public static void main(String[] args) {
        Vector v1 = new Vector(11);
        System.out.println(v1);
        System.out.println(v1.getSize());
        System.out.println();

        double[] array = {12.6, 12.7, 345.76, 45.7, 67.45};

        Vector v2 = new Vector(array);
        System.out.println(v2);
        System.out.println(v2.getSize());
        System.out.println();

        Vector v3 = new Vector(v2);
        System.out.println(v3);
        System.out.println(v3.getSize());
        System.out.println();

        Vector v4 = new Vector(8, array);
        System.out.println(v4);
        System.out.println(v4.getSize());
        System.out.println();
    }
}
