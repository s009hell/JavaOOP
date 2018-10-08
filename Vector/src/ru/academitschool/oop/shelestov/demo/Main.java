package ru.academitschool.oop.shelestov.demo;
import ru.academitschool.oop.shelestov.work.*;


public class Main {
    public static void main(String[] args) {
        double[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] array2 = {1, 2, 3, 4, 5};

        Vector v1 = new Vector(array);
        Vector v2 = new Vector(array2);

        v1.calculateSum(v2);
        System.out.println(v1);

    }
}
