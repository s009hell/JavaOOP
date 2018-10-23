package src.ru.academitschool.oop.shelestov.Work;

import ru.academitschool.oop.shelestov.work.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsQuantity, int columnsQuantity) {
        if (rowsQuantity < 1 || columnsQuantity < 1) {
            throw new IllegalArgumentException("Количество строк или столбцов матрицы не может быть меньше 1.");
        }

        rows = new Vector[rowsQuantity];

        for (int i = 0; i < rowsQuantity; i++) {
            rows[i] = new Vector(columnsQuantity);
        }
    }

    public Matrix(Matrix ob) {
        rows = new Vector[ob.getRowsQuantity()];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(ob.rows[i]);
        }
    }

    public Matrix(double[][] dArray) {
        int doubleArrayMaxSize = 0;

        for (double[] d : dArray) {
            if (d.length >= doubleArrayMaxSize) {
                doubleArrayMaxSize = d.length;
            }
        }

        if (dArray.length == 0 || doubleArrayMaxSize == 0) {
            throw new IllegalArgumentException("Количество строк или столбцов матрицы не может быть меньше 1.");
        }

        rows = new Vector[dArray.length];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(doubleArrayMaxSize, dArray[i]);
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

        rows = new Vector[vArray.length];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(vectorMaxSize);

            for (int j = 0; j < vArray[i].getSize(); j++) {
                rows[i].setComponent(j, vArray[i].getComponent(j));
            }
        }
    }

    private int getRowsQuantity() {
        return rows.length;
    }

    private int getColumnsQuantity() {
        return rows[0].getSize();
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= getRowsQuantity()) {
            throw new IndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getRowsQuantity()));
        }

        return rows[index];
    }

    public void setRow(int index, Vector newVector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getRowsQuantity()));
        }

        if (newVector.getSize() != getColumnsQuantity()) {
            throw new IllegalArgumentException("Недопустимый размер передаваемого вектора. Размер вектора дожен быть равен " + (getColumnsQuantity()));
        }

        rows[index] = new Vector(newVector);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= getColumnsQuantity()) {
            throw new IndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getColumnsQuantity()));
        }

        Vector vector = new Vector(getRowsQuantity());

        for (int i = 0; i < getRowsQuantity(); i++) {
            vector.setComponent(i, rows[i].getComponent(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] temp = new Vector[getColumnsQuantity()];

        for (int i = 0; i < getColumnsQuantity(); i++) {
            temp[i] = getColumn(i);
        }

        rows = temp;
    }

    public void multiply(double scalar) {
        for (Vector v : rows) {
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
        if (getRowsQuantity() != getColumnsQuantity()) {
            throw new IllegalArgumentException("Матрица должна быть квадратной.");
        }

        return getDeterminant(rows);
    }

    public Vector vectorMultiply(Vector vector) {
        if (vector.getSize() != getColumnsQuantity()) {
            throw new IllegalArgumentException("Недопустимый размер передаваемого вектора. Размер вектора дожен быть равен " + (getColumnsQuantity() + 1));
        }

        Vector newVector = new Vector(getRowsQuantity());

        for (int i = 0; i < getRowsQuantity(); i++) {
            newVector.setComponent(i, Vector.getMultiplication(vector, rows[i]));
        }

        return newVector;
    }

    public void calculateSum(Matrix ob) {
        if (getColumnsQuantity() != ob.getColumnsQuantity() || getRowsQuantity() != ob.getRowsQuantity()) {
            throw new IllegalArgumentException("Недопустимый размер передаваемой матрицы. Размер матрицы должен быть " + (getRowsQuantity()) + "х" + (getColumnsQuantity()));
        }

        for (int i = 0; i < getRowsQuantity(); i++) {
            rows[i].sum(ob.rows[i]);
        }
    }

    public void calculateDiff(Matrix ob) {
        if (getColumnsQuantity() != ob.getColumnsQuantity() || getRowsQuantity() != ob.getRowsQuantity()) {
            throw new IllegalArgumentException("Недопустимый размер передаваемой матрицы. Размер матрицы должен быть " + (getRowsQuantity()) + "х" + (getColumnsQuantity()));
        }

        for (int i = 0; i < getRowsQuantity(); i++) {
            rows[i].diff(ob.rows[i]);
        }
    }

    public static Matrix getSumMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsQuantity() != matrix1.getColumnsQuantity() || matrix1.getRowsQuantity() != matrix1.getRowsQuantity()) {
            throw new IllegalArgumentException("Размеры матриц должны быть одинакового размера.");
        }

        Matrix matrix = new Matrix(matrix1);
        matrix.calculateSum(matrix2);
        return matrix;
    }

    public static Matrix getDiffMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsQuantity() != matrix1.getColumnsQuantity() || matrix1.getRowsQuantity() != matrix1.getRowsQuantity()) {
            throw new IllegalArgumentException("Размеры матриц должны быть одинакового размера.");
        }

        Matrix matrix = new Matrix(matrix1);
        matrix.calculateDiff(matrix2);
        return matrix;
    }

    public static Matrix getMultiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsQuantity() != matrix2.getRowsQuantity()) {
            throw new IllegalArgumentException("Количество столбцов матрицы 1 должно совпадать с количеством строк матрицы 2");
        }

        Matrix pieceMatrix = new Matrix(matrix1.getRowsQuantity(), matrix2.getColumnsQuantity());

        for (int i = 0; i < matrix1.getRowsQuantity(); i++) {
            for (int j = 0; j < matrix2.getColumnsQuantity(); j++) {
                double piece = 0;

                for (int k = 0; k < matrix1.getColumnsQuantity(); k++) {
                    piece += matrix1.rows[i].getComponent(k) * matrix2.rows[k].getComponent(j);
                }

                pieceMatrix.rows[i].setComponent(j, piece);
            }
        }

        return pieceMatrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");

        for (int i = 0; i < rows.length; i++) {
            sb.append(rows[i].toString());

            if (i != rows.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("}");

        return sb.toString();
    }
}
