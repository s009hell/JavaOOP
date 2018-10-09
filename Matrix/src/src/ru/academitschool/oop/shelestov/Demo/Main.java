package src.ru.academitschool.oop.shelestov.Demo;

import src.ru.academitschool.oop.shelestov.Work.Matrix;

public class Main {
    public static void main(String[] args) {
        double [][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        Matrix m1 = new Matrix(array);
        Matrix m2 = new Matrix(m1);

        m2.transpose();

        System.out.println("Транспонирование матрицы:");
        System.out.println(m2);

        System.out.println("Получение вектора строки:");
        System.out.println(m2.getVector(2));

    }
}
