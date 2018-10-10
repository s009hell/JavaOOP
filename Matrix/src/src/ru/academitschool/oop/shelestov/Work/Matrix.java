package src.ru.academitschool.oop.shelestov.Work;

import ru.academitschool.oop.shelestov.work.*;
import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        if (n < 1 || m < 1) {
            throw new IllegalArgumentException("Недопустимый индекс.");
        }

        matrix = new Vector[n];

        for (int i = 0; i < n; i++) {
            matrix[i] = new Vector(m);
        }
    }

    public Matrix(Matrix ob) {
        matrix = Arrays.copyOf(ob.matrix, ob.matrix.length);
    }

    public Matrix(double[][] array) {
        matrix = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            matrix[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector[] array) {
        matrix = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            matrix[i] = new Vector(array[i]);
        }
    }

    //получение количества строк
    private int getSize() {
        return matrix.length;
    }

    //получение количества столбцов
    private int getRowSize() {
        return matrix[0].getSize();
    }

    //получение вектора-строки по индексу
    public Vector getVector(int index) {
        if (index < 0 || index > matrix.length) {
            throw new IllegalArgumentException("Недопустимый индекс.");
        }

        return matrix[index];
    }

    //задание вектора-строки по индексу
    public void setVector(int index, Vector newVector) {
        if (index < 0 || index > matrix.length) {
            throw new IllegalArgumentException("Недопустимый индекс.");
        }

        matrix[index] = newVector;
    }

    //получение вектора-столбца по индексу
    public Vector getColumnVector(int index) {
        if (index < 0 || index > matrix.length) {
            throw new IllegalArgumentException("Недопустимый индекс.");
        }

        Vector newVector = new Vector(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            newVector.setComponent(i, matrix[i].getComponent(index));
        }

        return newVector;
    }

    //транспонирование матрицы
    public void transpose() {
        Vector[] temp = new Vector[getRowSize()];

        for (int i = 0; i < getRowSize(); i++) {
            temp[i] = new Vector(getColumnVector(i));
        }

        matrix = temp;
    }

    //умножение на скаляр
    public void calculateMultiplication(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            matrix[i].multiply(scalar);
        }
    }

    //вычисление определителя матрицы
    private double calculateDeterminant(Vector[] matrix) {
        if (matrix.length == 1) {
            return matrix[0].getComponent(0);
        } else if (matrix.length == 2) {
            return matrix[0].getComponent(0) * matrix[1].getComponent(1) - matrix[0].getComponent(1) * matrix[1].getComponent(0);
        }

        Vector[] array = new Vector[matrix.length - 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Vector(matrix.length - 1);
        }

        double sum = 0;
        int exception = 0;

        for (int i = 0; i < matrix.length; i++) {
            int x = 0;

            for (int j = 0; j < matrix.length; j++) {
                if (j != exception) {
                    int y = 0;

                    for (int k = 1; k < matrix.length; k++) {
                        array[x].setComponent(y, matrix[j].getComponent(k));
                        y++;
                    }

                    x++;
                }
            }

            sum += Math.pow(-1, i) * matrix[i].getComponent(0) * calculateDeterminant(array);
            exception++;
        }
        return sum;
    }

    public double getDeterminant() {
        return calculateDeterminant(matrix);
    }

    //умножение матрицы на вектор
    public Vector getVectorMultiplication(Vector vector) {
        Vector newVector = new Vector(getSize());

        for (int i = 0; i < getSize(); i++) {
            double sum = 0;

            for (int j = 0; j < getRowSize(); j++) {
                sum += matrix[i].getComponent(j) * vector.getComponent(j);
            }

            newVector.setComponent(i, sum);
        }

        return newVector;
    }

    //сложение матриц
    public Matrix calculateSum(Matrix ob) {
        for (int i = 0; i < getSize(); i++) {
            matrix[i].sum(ob.matrix[i]);
        }

        return this;
    }

    //сложение матриц
    public Matrix calculateDifference(Matrix ob) {
        for (int i = 0; i < getSize(); i++) {
            matrix[i].diff(ob.matrix[i]);
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < getSize(); i++) {
            sb.append(matrix[i].toString());

            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);
        return matrix.calculateSum(matrix2);
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);
        return matrix.calculateDifference(matrix2);
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        Vector[] newVector = new Vector[matrix1.getSize()];

        for (int i = 0; i < matrix1.getSize(); i++) {
            newVector[i] = new Vector(matrix2.getRowSize());

            for (int j = 0; j < matrix2.getRowSize(); j++) {
                int sum = 0;

                for (int l = 0; l < matrix1.getRowSize(); l++) {
                    sum += matrix1.matrix[i].getComponent(l) * matrix2.matrix[l].getComponent(j);
                }

                newVector[i].setComponent(j, sum);
            }
        }

        return new Matrix(newVector);
    }
}
