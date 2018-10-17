package ru.academitschool.oop.shelestov.work;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Минимальный размер массива - 1.");
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Минимальный размер массива - 1.");
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Минимальный размер массива - 1.");
        }

        components = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return components.length;
    }

    public void expand(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            double[] old = this.components;
            this.components = Arrays.copyOf(old, vector.getSize());
        }
    }

    public void sum(Vector vector) {
        expand(vector);

        for (int i = 0; i < vector.getSize(); ++i) {
            components[i] += vector.components[i];
        }
    }

    public void diff(Vector vector) {
        expand(vector);

        for (int i = 0; i < vector.getSize(); ++i) {
            components[i] -= vector.components[i];
        }
    }

    public void multiply(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverseVector() {
        multiply(-1);
    }

    public double getLength() {
        double length = 0;

        for (double component : components) {
            length += Math.pow(component, 2);
        }

        return Math.sqrt(length);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы индексов массива.");
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= this.getSize()) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы индексов массива.");
        }

        components[index] = value;
    }

    @Override
    public String toString() {
        String s1 = Arrays.toString(components).replace("[", "{");
        return s1.replace("]", "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector temp = new Vector(vector1);
        temp.sum(vector2);

        return temp;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector temp = new Vector(vector1);
        temp.diff(vector2);

        return temp;
    }

    public static double getMultiplication(Vector vector1, Vector vector2) {
        double result = 0;
        int minSize = Math.min(vector1.getSize(), vector2.getSize());

        for (int i = 0; i < minSize; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}
