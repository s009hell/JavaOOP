package src.ru.academitschool.oop.shelestov.Demo;

import src.ru.academitschool.oop.shelestov.Work.Matrix;

public class Main {
    public static void main(String[] args) {
        double [][] array = {
                {3, 2, 3},
                {2, 3, 2},
                {6, 7, 8}
        };


        Matrix m2 = new Matrix(array);


        System.out.println(m2.getVector(0));
        System.out.println(m2.getVector(1));
        System.out.println(m2.getVector(2));

        System.out.println(m2.getDeterminant());

        System.out.println(m2);

    }
}
