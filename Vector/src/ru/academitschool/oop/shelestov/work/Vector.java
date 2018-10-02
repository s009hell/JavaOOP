package ru.academitschool.oop.shelestov.work;

public class Vector {
    private Double[] components;

    public Vector(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        else components = new Double[n];
    }


}
