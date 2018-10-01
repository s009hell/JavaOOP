package Demo;

import Work.Square;
import Work.Triangle;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(7.0);
        Square square2 = new Square(2.0);
        Square square3 = new Square(11.0);

        System.out.println("Первый квадрат:");
        System.out.println("Высота = " + square1.getWidth() + ", ширина = " + square1.getHeight() + ", площадь = " + square1.getArea() + ", периметр = " + square1.getPerimeter() + ".");
        System.out.println("Второй квадрат:");
        System.out.println("Высота = " + square2.getWidth() + ", ширина = " + square2.getHeight() + ", площадь = " + square2.getArea() + ", периметр = " + square2.getPerimeter() + ".");
        System.out.println("Третий квадрат:");
        System.out.println("Высота = " + square3.getWidth() + ", ширина = " + square3.getHeight() + ", площадь = " + square3.getArea() + ", периметр = " + square3.getPerimeter() + ".");
        System.out.println();

        Triangle triangle1 = new Triangle(0.0, 0.0, 1.0, 2.0, 0.0, 1.0);
        Triangle triangle2 = new Triangle(11.0, 2.0, 1.0, 2.0, 7.0, 6.0);
        Triangle triangle3 = new Triangle(0.0, 0.0, 5.0, 4.0, 1.0, 11.0);

        System.out.println("Первый треугольник:");
        System.out.println("Высота = " + triangle1.getWidth() + ", ширина = " + triangle1.getHeight() + ", площадь = " + triangle1.getArea() + ", периметр = " + triangle1.getPerimeter() + ".");
        System.out.println("Второй треугольник:");
        System.out.println("Высота = " + triangle2.getWidth() + ", ширина = " + triangle2.getHeight() + ", площадь = " + triangle2.getArea() + ", периметр = " + triangle2.getPerimeter() + ".");
        System.out.println("Третий треугольник:");
        System.out.println("Высота = " + triangle3.getWidth() + ", ширина = " + triangle3.getHeight() + ", площадь = " + triangle3.getArea() + ", периметр = " + triangle3.getPerimeter() + ".");
        System.out.println();
    }
}
