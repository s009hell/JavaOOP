package ru.academitschool.oop.shelestov.work.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "Прямоугольник: высота = " + getWidth() + ", ширина = " + getHeight() + ", площадь = " + getArea() + ", периметр = " + getPerimeter() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;

        return rectangle.width == width && rectangle.height == height;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(width + height);
    }
}
