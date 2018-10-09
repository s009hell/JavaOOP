package src.ru.academitschool.oop.shelestov.Demo;

import src.ru.academitschool.oop.shelestov.Work.Matrix;

public class Main {
    public static void main(String[] args) {
        double [][] array = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };


        Matrix m1 = new Matrix(5,2);
        Matrix m2 = new Matrix(array);

        System.out.println(m2.matrix[2]);


    }
}
