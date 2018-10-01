package Demo;

import Work.Circle;
import Work.Rectangle;
import Work.Square;
import Work.Triangle;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(7.0);
        Square square2 = new Square(2.0);
        Square square3 = new Square(11.0);

        System.out.println("Первый квадрат:");
        System.out.println(square1.toString());
        System.out.println("Второй квадрат:");
        System.out.println(square2.toString());
        System.out.println("Третий квадрат:");
        System.out.println(square3.toString());
        System.out.println();

        Triangle triangle1 = new Triangle(0.0, 0.0, 1.0, 2.0, 0.0, 1.0);
        Triangle triangle2 = new Triangle(11.0, 2.0, 1.0, 2.0, 7.0, 6.0);
        Triangle triangle3 = new Triangle(0.0, 0.0, 5.0, 4.0, 1.0, 11.0);

        System.out.println("Первый треугольник:");
        System.out.println(triangle1.toString());
        System.out.println("Второй треугольник:");
        System.out.println(triangle2.toString());
        System.out.println("Третий треугольник:");
        System.out.println(triangle3.toString());
        System.out.println();

        Rectangle rectangle1 = new Rectangle(2, 3);
        Rectangle rectangle2 = new Rectangle(10, 11);
        Rectangle rectangle3 = new Rectangle(1, 2);

        System.out.println("Первый прямоугольник:");
        System.out.println(rectangle1.toString());
        System.out.println("Второй прямоугольник:");
        System.out.println(rectangle2.toString());
        System.out.println("Третий прямоугольник:");
        System.out.println(rectangle3.toString());
        System.out.println();

        Circle circle1 = new Circle(15);
        Circle circle2 = new Circle(3);
        Circle circle3 = new Circle(7);

        System.out.println("Первый круг:");
        System.out.println(circle1.toString());
        System.out.println("Второй круг:");
        System.out.println(circle2.toString());
        System.out.println("Третий круг:");
        System.out.println(circle3.toString());
        System.out.println();
    }
}
