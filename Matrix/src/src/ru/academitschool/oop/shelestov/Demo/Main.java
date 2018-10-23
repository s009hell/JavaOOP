package src.ru.academitschool.oop.shelestov.Demo;

import ru.academitschool.oop.shelestov.work.Vector;
import src.ru.academitschool.oop.shelestov.Work.Matrix;

public class Main {
    public static void main(String[] args) {

        Matrix m1 = new Matrix(2, 3);

        System.out.println("Матрица созданная конструктором (m, n):");
        System.out.println(m1);
        System.out.println();

        double[][] dArray = {
                {1.0, 2.0, 3.0, 4.0},
                {5.0, 6.0, 7.0},
                {8.0, 9.0},
        };

        Matrix m2 = new Matrix(dArray);

        System.out.println("Матрица созданная конструктором (double[]):");
        System.out.println(m2);
        System.out.println();

        Matrix m3 = new Matrix(m2);

        System.out.println("Матрица созданная конструктором (Matrix):");
        System.out.println(m3);
        System.out.println();

        Vector[] vArray = new Vector[3];

        double[] d1 = {3.0, 2.0, 3.0, 2.0};
        vArray[0] = new Vector(d1);
        double[] d2 = {4.0, 5.0, 4.0, 5.0};
        vArray[1] = new Vector(d2);
        double[] d3 = {7.0, 1.0, 7.0, 1.0};
        vArray[2] = new Vector(d3);

        Matrix m4 = new Matrix(vArray);

        System.out.println("Матрица созданная конструктором (Vector[]):");
        System.out.println(m4);
        System.out.println();

        System.out.println("Получение строку из матрицы с индексом 2.");
        System.out.println("Исходная матрица:");
        System.out.println(m3);
        System.out.println("Строка с индексом 2:");
        System.out.println(m3.getRow(2));
        System.out.println();


        System.out.println("Задать строку в матрице с индексом 2 из вектора.");
        System.out.println("Исходная матрица:");
        System.out.println(m2);
        System.out.println("Передаваемый вектор:");
        System.out.println(vArray[1]);
        m2.setRow(2, vArray[1]);
        System.out.println("Результат: ");
        System.out.println(m2);
        System.out.println();

        System.out.println("Получение стобец из матрицы с индексом 2.");
        System.out.println("Исходная матрица:");
        System.out.println(m2);
        System.out.println("Столбец с индексом 2:");
        System.out.println(m2.getColumn(2));
        System.out.println();

        System.out.println("Транспонирование матрицы.");
        System.out.println("Исходная матрица:");
        System.out.println(m2);
        System.out.println("Транспонированная матрица:");
        m2.transpose();
        System.out.println(m2);
        System.out.println();

        System.out.println("Умножение матрицы на скаляр 3.");
        System.out.println("Исходная матрица:");
        System.out.println(m2);
        System.out.println("Результат:");
        m2.multiply(3);
        System.out.println(m2);
        System.out.println();

        double[][] dArray2 = {
                {-1.0, 2.0, 3.0, 4.0},
                {4.0, -5.0, 6.0, 7.0},
                {7.0, 8.0, -9.0, 10.0},
                {11.0, 12.0, 13.0, -14.0},
        };

        Matrix m5 = new Matrix(dArray2);
        System.out.println("Получение детерминанта матрицы.");
        System.out.println("Исходная матрица:");
        System.out.println(m5);
        System.out.println("Детерминант:");
        System.out.println(m5.getDeterminant());
        System.out.println();

        System.out.println("Умножение матрицы на вектор.");
        System.out.println("Исходная матрица:");
        System.out.println(m5);
        System.out.println("Передаваемый вектор:");
        System.out.println(vArray[1]);
        m5.vectorMultiply(vArray[1]);
        System.out.println("Результат: ");
        System.out.println(m5.vectorMultiply(vArray[1]));
        System.out.println();

        System.out.println("Сумма двух матриц.");
        System.out.println("Исходная матрица:");
        System.out.println(m3);
        System.out.println("Передаваемая матрица:");
        System.out.println(m4);
        System.out.println("Результат: ");
        m3.calculateSum(m4);
        System.out.println(m3);
        System.out.println();

        System.out.println("Разность двух матриц.");
        System.out.println("Исходная матрица:");
        System.out.println(m3);
        System.out.println("Передаваемая матрица:");
        System.out.println(m4);
        System.out.println("Результат: ");
        m3.calculateDiff(m4);
        System.out.println(m3);
        System.out.println();

        System.out.println("Сумма двух матриц (Static).");
        System.out.println("Первая матрица:");
        System.out.println(m3);
        System.out.println("Вторая матрица:");
        System.out.println(m4);
        System.out.println("Результат: ");
        System.out.println(Matrix.getSumMatrix(m3, m4));
        System.out.println();

        System.out.println("Разность двух матриц (Static).");
        System.out.println("Первая матрица:");
        System.out.println(m3);
        System.out.println("Вторая матрица:");
        System.out.println(m4);
        System.out.println("Результат: ");
        System.out.println(Matrix.getDiffMatrix(m3, m4));
        System.out.println();

        System.out.println("Произведение двух матриц (Static).");
        System.out.println("Первая матрица:");
        System.out.println(m3);
        System.out.println("Вторая матрица:");
        System.out.println(m5);
        System.out.println("Результат: ");
        System.out.println(Matrix.getMultiplyMatrix(m3, m5));
        System.out.println();
    }
}
