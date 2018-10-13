package ru.academitschool.oop.shelestov.demo;

import ru.academitschool.oop.shelestov.work.*;

public class Main {
    public static void main(String[] args) {
        double[] array = {1, 1, 1, 1, 1, 1, 1};
        double[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Vector v1 = new Vector(5);
        System.out.println(v1);

        Vector v15 = new Vector(2);
        v15.expand(v1);
        System.out.println(v15);

        Vector v2 = new Vector(array);
        Vector v3 = new Vector(v2);
        Vector v4 = new Vector(array2);
        Vector v5 = new Vector(3, array2);

        System.out.println("Сумма векторов:");
        System.out.println(v2);
        System.out.println(v4);
        v2.sum(v4);
        System.out.println(v2);

        System.out.println("Раность векторов векторов:");
        System.out.println(v5);
        System.out.println(v3);
        v5.diff(v3);
        System.out.println(v5);

        System.out.println("Произведение вектора на 2:");
        System.out.println(v4);
        v4.multiply(2);
        System.out.println(v4);

        System.out.println("Разворот вектора:");
        v4.reverseVector();
        System.out.println(v4);

        System.out.println("Длина вектора:");
        v1 = new Vector(array);
        System.out.println(v1.getLength());

        System.out.println("Сравнение вектора:");
        v5 = new Vector(array);
        System.out.println(v4.equals(v5));

        System.out.println("Получить 3 компонент из вектора:");
        v4 = new Vector(array2);
        System.out.println(v4.getComponent(3));

        System.out.println("Установить компонент:");
        v4.setComponent(3,666);
        System.out.println(v4);

        System.out.println("Создать новый вектор путем сложения векторов:");
        System.out.println(v4);
        System.out.println(v5);
        Vector v6 = Vector.getSum(v4, v5);
        System.out.println(v6);

        System.out.println("Создать новый вектор путем вычитания векторов:");
        System.out.println(v4);
        System.out.println(v5);
        v6 = Vector.getDifference(v4, v5);
        System.out.println(v6);

        System.out.println("Скалярное произведение векторов:");
        System.out.println(v4);
        System.out.println(v5);
        System.out.println(Vector.getMultiplication(v4, v5));



    }
}
