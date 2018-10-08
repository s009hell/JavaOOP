package ru.academitschool.oop.shelestov.work;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        else components = new double[n];
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

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");

        for (int i = 0; i < components.length; i++) {
            if (i != components.length - 1) {
                str.append(components[i]).append(", ");
            } else {
                str.append(components[i]);
            }
        }

        str.append("}");

        return str.toString();
    }

    public void calculateSum (Vector vector) {
        for (int i = 0; i < Math.min(components.length, vector.components.length); i++) {
            components[i] += vector.components[i];
        }
    }
}
