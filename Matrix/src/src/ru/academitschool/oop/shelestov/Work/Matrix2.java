package src.ru.academitschool.oop.shelestov.Work;

import ru.academitschool.oop.shelestov.work.Vector;


public class Matrix2 {
    private Vector[] vectorArray;

    public Matrix2(int rowQuantity, int columnQuantity) {
        if (rowQuantity < 1 || columnQuantity < 1) {
            throw new IllegalArgumentException("Количество строк или столбцов матрицы не может быть меньше 1.");
        }

        vectorArray = new Vector[rowQuantity];

        for (int i = 0; i < rowQuantity; i++) {
            vectorArray[i] = new Vector(columnQuantity);
        }
    }

    public Matrix2(Matrix2 ob) {
        vectorArray = new Vector[ob.vectorArray.length];

        for (int i = 0; i < vectorArray.length; i++) {
            vectorArray[i] = new Vector(ob.vectorArray[i]);
        }
    }

    public Matrix2(double[][] dArray) {
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

    public Matrix2(Vector[] vArray) {
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
        if (index < 0 || index >= vectorArray.length) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getSize()[0] + 1));
        }

        return vectorArray[index];
    }

    public void setVector(int index, Vector newVector) {
        if (index < 0 || index >= vectorArray.length) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый индекс. Индек дожен быть больше -1 и меньше " + (getSize()[0] + 1));
        }

        if (newVector.getSize() > getSize()[1]) {
            throw new ArrayIndexOutOfBoundsException("Недопустимый размер вектора. Размер вектора дожен быть меньше " + (getSize()[1] + 1));
        }

        vectorArray[index] = new Vector(newVector);
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
