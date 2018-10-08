package ru.academitschool.oop.shelestov.work;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        components = Arrays.copyOf(array, n);
    }

    private int getSize() {
        return components.length;
    }

    private void expand(Vector vector) {
        if (this.getSize() < vector.getSize()) {
            double[] old = this.components;
            this.components = new double[Math.max(this.getSize(), vector.getSize())];
            System.arraycopy(old, 0, this.components, 0, old.length);
        }
    }

    public void calculateSum(Vector vector) {
        expand(vector);

        for (int i = 0; i < vector.getSize(); ++i) {
            components[i] += vector.components[i];
        }
    }

    public void calculateDifference(Vector vector) {
        expand(vector);

        for (int i = 0; i < vector.getSize(); ++i) {
            components[i] -= vector.components[i];
        }
    }

    public void calculateMultiplication(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void reverseVector() {
        for (int i = 0; i < components.length; i++) {
            components[i] *= -1;
        }
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
            throw new IllegalArgumentException();
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= this.getSize()) {
            throw new IllegalArgumentException();
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
        temp.calculateSum(vector2);

        return temp;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector temp = new Vector(vector1);
        temp.calculateDifference(vector2);

        return temp;
    }

    public static double getMultiplication(Vector vector1, Vector vector2) {
        double result = 0;

        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}
