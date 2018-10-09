package src.ru.academitschool.oop.shelestov.Work;

import ru.academitschool.oop.shelestov.work.*;
import java.util.Arrays;

public class Matrix {
    public Vector[] matrix;

    public Matrix(int n, int m) {
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

    public int getSize() {
        return matrix.length;
    }

    
}
