/*
package src.ru.academitschool.oop.shelestov.Work;

import ru.academitschool.oop.shelestov.work.*;
import java.util.Arrays;

public class Matrix {
    private Vector[] vectorArray;

    public Matrix(int rowQuantity, int columnQuantity) {
        if (rowQuantity < 1 || columnQuantity < 1) {
            throw new IllegalArgumentException("Количество строк или столбцов матрицы не может быть меньше 1.");
        }

        vectorArray = new Vector[rowQuantity];

        for (int i = 0; i < rowQuantity; i++) {
            vectorArray[i] = new Vector(columnQuantity);
        }
    }

    public Matrix(Matrix ob) {
        vectorArray = new Vector[ob.vectorArray.length];

        for (int i = 0; i < vectorArray.length; i++) {
            vectorArray[i] = new Vector(ob.vectorArray[i]);
        }
    }

    public Matrix(double[][] dArray) {
        boolean isZeroSize = false;
        int doubleArrayMaxSize = 0;

        for (double[] d : dArray) {
            if (d.length == 0) {
                isZeroSize = true;
                break;
            } else if (d.length >= doubleArrayMaxSize) {
                doubleArrayMaxSize = d.length;
            }
        }

        if (dArray.length == 0 || isZeroSize) {
            throw new IllegalArgumentException("Количество строк или столбцов матрицы не может быть меньше 1.");
        }

        vectorArray = new Vector[dArray.length];

        for (int i = 0; i < vectorArray.length; i++) {
            vectorArray[i] = new Vector(doubleArrayMaxSize, dArray[i]);
        }
    }

    public Matrix(Vector[] vArray) {
        if (vArray.length < 1) {
            throw new IllegalArgumentException("Количество строк матрицы не может быть меньше 1.");
        }

        int vectorMaxSize = 0;

        for (Vector v : vArray) {
            if (v.getSize() >= vectorMaxSize) {
                vectorMaxSize = v.getSize();
            }
        }

        vectorArray = new Vector[vArray.length];

        for (int i = 0; i < vectorArray.length; i++) {
            vectorArray[i] = new Vector(vectorMaxSize);

            for (int j = 0; j < vArray[i].getSize(); j++) {
                vectorArray[i].setComponent(j, vArray[i].getComponent(j));
            }
        }
    }

    public int[] getSize() {
        return new int[] {vectorArray.length, vectorArray[0].getSize()};
    }

    public Vector getVector(int index) {
        if (index < 0 || index > vectorArray.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше 0 и меньше " + getSize()[0]);
        }

        return vectorArray[index];
    }

    ==============================================================================

    public void setVector(int index, Vector newVector) {
        if (index < 0 || index >= vectorArray.length) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getSize()[0] + 1));
        }

        if (newVector.getSize() > getSize()[1]) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый размер вектора. Размер вектора дожен быть меньше " + (getSize()[1] + 1));
        }

        vectorArray[index] = new Vector(newVector);
    }

    ==============================================================================

    //получение вектора-столбца по индексу
    public Vector getColumnVector(int index) {
        if (index < 0 || index > matrix.length) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс.");
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
        if (vector.getLength() < 0) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый размер вектора.");
        }

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

    private Matrix calculateMultiply(Matrix ob) {
        for (int i = 0; i < getSize(); i++) {
            matrix[i].multiply(ob.matrix[i]);
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
        Matrix matrix = new Matrix(matrix1);
        return matrix.calculateMultiply(matrix2);
    }
}
*/
