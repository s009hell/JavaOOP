package src.ru.academitschool.oop.shelestov.Demo;

import ru.academitschool.oop.shelestov.work.Vector;
import src.ru.academitschool.oop.shelestov.Work.Matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3, 4);

        double[][] doubleArray = {
                {5.0, 9.0, 7.0},
                {9.0, 6.0, 3.0},
                {8.0, 4.0, 2.0}
        };

        Matrix m2 = new Matrix(doubleArray);

        double[] d1 = {11.0, 17.0, 15.0, 19.0};
        double[] d2 = {10.0, 12.0, 14.0, 16.0};
        double[] d3 = {9.0, 7.0, 5.0, 3.0};

        Vector[] vectorArray = {
                new Vector(d1),
                new Vector(d2),
                new Vector(d3),
        };

        Matrix m3 = new Matrix(vectorArray);
        m1 = new Matrix(m3);

        System.out.println("*** Меню ***");
        System.out.println("1 - Получить вектор-строку по индексу.");
        System.out.println("2 - Задать вектор-строку по индексу.");
        System.out.println("3 - Получить вектор-столбец по индексу.");
        System.out.println("4 - Выполнить транспонирование матрицы.");
        System.out.println("5 - Умножение матрицы на скаляр.");
        System.out.println("6 - Вычислить определитель матрицы.");
        System.out.println("7 - Умножение матрицы на вектор.");
        System.out.println("8 - Сложение матриц.");
        System.out.println("9 - Вычитание матриц.");
        System.out.println("10 - Сложение матриц (static).");
        System.out.println("11 - Вычитание матриц (static).");
        System.out.println("12 - Умножение матриц (static).");


        System.out.println("0 - Выход.");
        System.out.print("Введите номер пункта меню: ");

        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int index;

        switch (in) {
            default:
                System.out.println();
                System.out.println("Введен некорректный пункт меню.");
                System.out.println();
                break;
            case "0":
                break;
            case "1":
                System.out.println();
                System.out.print("Введите индекс строки (0 - 2): ");
                index = scanner.nextInt();
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                System.out.println("Строка с индексом " + index + ":");
                System.out.println(m2.getVector(index));
                System.out.println();
                break;
            case "2":
                System.out.println();
                System.out.print("Введите индекс строки (0 - 2): ");
                index = scanner.nextInt();
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                double[] d = {1, 1, 1};
                Vector newVector = new Vector(d);
                System.out.println("Добавляемый вектор:");
                System.out.println(newVector);
                System.out.println("Новая матрица:");
                m2.setVector(index, newVector);
                System.out.println(m2);
                System.out.println();
                break;
            case "3":
                System.out.println();
                System.out.print("Введите индекс столбца (0 - 2): ");
                index = scanner.nextInt();
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                System.out.println("Столбец с индексом " + index + ":");
                System.out.println(m2.getColumnVector(index));
                System.out.println();
                break;
            case "4":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m1);
                m1.transpose();
                System.out.println("Транспонированная матрица:");
                System.out.println(m1);
                System.out.println();
                break;
            case "5":
                System.out.println();
                System.out.print("Введите скаляр: ");
                double scalar = scanner.nextDouble();
                System.out.println("Исходная матрица:");
                System.out.println(m1);
                m1.calculateMultiplication(scalar);
                System.out.println("Результат умножения матрицы на скаляр:");
                System.out.println(m1);
                System.out.println();
                break;
            case "6":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                System.out.println("Определитель матрицы:");
                System.out.println(m2.getDeterminant());
                System.out.println();
                break;
            case "7":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                double[] dArray = {3.0, 2.0, 1.0};
                newVector = new Vector(dArray);
                System.out.println("Вектор:");
                System.out.println(newVector);
                System.out.println("Результат умножения:");
                m2.getVectorMultiplication(newVector);
                System.out.println(m2.getVectorMultiplication(newVector));
                System.out.println();
                break;
            case "8":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                System.out.println("Слагаемая матрица:");
                System.out.println(m1);
                System.out.println("Результат сложения:");
                System.out.println(m2.calculateSum(m1));
                System.out.println();
                break;
            case "9":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                System.out.println("Вычитаемая матрица:");
                System.out.println(m1);
                System.out.println("Результат вычитания:");
                System.out.println(m2.calculateDifference(m1));
                System.out.println();
                break;
            case "10":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m1);
                System.out.println("Вычитаемая матрица:");
                System.out.println(m2);
                System.out.println("Результат сложения:");
                System.out.println(Matrix.getSum(m1, m2));
                System.out.println();
                break;
            case "11":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m1);
                System.out.println("Вычитаемая матрица:");
                System.out.println(m2);
                System.out.println("Результат вычитания:");
                System.out.println(Matrix.getDifference(m1, m2));
                System.out.println();
                break;
            case "12":
                System.out.println();
                System.out.println("Исходная матрица:");
                System.out.println(m2);
                System.out.println("Матрица на которую производится умножение:");
                System.out.println(m1);
                System.out.println("Результат умножения:");
                System.out.println(Matrix.getMultiplication(m2, m1));
                System.out.println();
                break;
        }
    }
}
