package src.ru.academitschool.oop.shelestov.Work;

import ru.academitschool.oop.shelestov.work.Vector;

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
        vectorArray = new Vector[ob.getSize()[0]];

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

    private int[] getSize() {
        return new int[] {vectorArray.length, vectorArray[0].getSize()};
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= getSize()[0]) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getSize()[0]));
        }

        return vectorArray[index];
    }

    public void setVector(int index, Vector newVector) {
        if (index < 0 || index >= vectorArray.length) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getSize()[0]));
        }

        if (newVector.getSize() > getSize()[1]) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый размер передаваемого вектора. Размер вектора дожен быть меньше " + (getSize()[1]));
        }

        vectorArray[index] = new Vector(newVector);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= getSize()[1]) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getSize()[1]));
        }

        Vector vector = new Vector(getSize()[0]);

        for (int i = 0; i < getSize()[0]; i++) {
            vector.setComponent(i, vectorArray[i].getComponent(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] temp = new Vector[getSize()[1]];

        for (int i = 0; i < getSize()[1]; i++) {
            temp[i] = getColumn(i);
        }

        vectorArray = temp;
    }

    public void multiply(double scalar) {
        for (Vector v : vectorArray) {
            v.multiply(scalar);
        }
    }

    private double getDeterminant(Vector[] matrix) {
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

            sum += Math.pow(-1, i) * matrix[i].getComponent(0) * getDeterminant(array);
            exception++;
        }
        return sum;
    }

    public double getDeterminant() {
        if (getSize()[0] != getSize()[1]) {
            throw new ArrayIndexOutOfBoundsException("Матрица должна быть квадратной.");
        }

        return getDeterminant(vectorArray);
    }

    public Vector vectorMultiply(Vector vector) {
        if (vector.getSize() != getSize()[1]) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый размер передаваемого вектора. Размер вектора дожен быть равен " + (getSize()[1] + 1));
        }

        Vector newVector = new Vector(getSize()[0]);

        for (int i = 0; i < getSize()[0]; i++) {
            double sum = 0;

            for (int j = 0; j < getSize()[1]; j++) {
                sum += vectorArray[i].getComponent(j) * vector.getComponent(j);
            }

            newVector.setComponent(i, sum);
        }

        return newVector;
    }

    public void calculateSum(Matrix ob) {
        if (!Arrays.equals(getSize(), ob.getSize())) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый размер передаваемой матрицы. Размер матрицы должен быть " + (getSize()[0]) + "х" + (getSize()[1]));
        }

        for (int i = 0; i < getSize()[0]; i++) {
            vectorArray[i].sum(ob.vectorArray[i]);
        }
    }

    public void calculateDiff(Matrix ob) {
        if (!Arrays.equals(getSize(), ob.getSize())) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый размер передаваемой матрицы. Размер матрицы должен быть " + (getSize()[0]) + "х" + (getSize()[1]));
        }

        for (int i = 0; i < getSize()[0]; i++) {
            vectorArray[i].diff(ob.vectorArray[i]);
        }
    }

    public static Matrix getSumMatrix(Matrix matrix1, Matrix matrix2) {
        if (!Arrays.equals(matrix1.getSize(), matrix2.getSize())) {
            throw new ArrayIndexOutOfBoundsException("Размеры матриц должны быть одинакового размера.");
        }

        Matrix matrix = new Matrix(matrix1);
        matrix.calculateSum(matrix2);
        return matrix;
    }

    public static Matrix getDiffMatrix(Matrix matrix1, Matrix matrix2) {
        if (!Arrays.equals(matrix1.getSize(), matrix2.getSize())) {
            throw new ArrayIndexOutOfBoundsException("Размеры матриц должны быть одинакового размера.");
        }

        Matrix matrix = new Matrix(matrix1);
        matrix.calculateDiff(matrix2);
        return matrix;
    }

    public static Matrix getMultiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (!Arrays.equals(matrix1.getSize(), matrix2.getSize())) {
            throw new ArrayIndexOutOfBoundsException("Размеры матриц должны быть одинакового размера.");
        }

        Matrix matrix = new Matrix(matrix1);

        for (int i = 0; i < matrix.getSize()[0]; i++) {
            for (int j = 0; j < matrix.getSize()[1]; j++) {
                matrix.vectorArray[i].setComponent(j, (matrix1.vectorArray[i].getComponent(j) * matrix2.vectorArray[i].getComponent(j)));
            }
        }

        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < vectorArray.length; i++) {
            sb.append(vectorArray[i].toString());

            if (i != vectorArray.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }
}
